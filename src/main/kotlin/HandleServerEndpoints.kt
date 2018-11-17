import dao.*
import dao.Facilities
import dao.FacilitiesTypes
import dao.RoomEntity
import dao.Rooms
import extensions.maxLength
import io.ktor.application.ApplicationCall
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.request.uri
import io.ktor.response.respond
import io.ktor.util.pipeline.PipelineContext
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import utills.ResponseErrorCode

//DATABASE
fun getAllRooms() = transaction {
    dao.Rooms.selectAll().map {
        Room(it[Rooms.id].value, it[Rooms.number], it[Rooms.floor], it[Rooms.description], it[Rooms.capacity])
    }
}

fun getAllFacilities() = transaction {
    dao.Facilities.selectAll().map {
        Facility(it[Facilities.id].value, it[Facilities.type].ordinal, it[Facilities.isActive])
    }
}

fun updateRoomDesc(id: Int, newDesc: String) = transaction {
    dao.Rooms.update({ (Rooms.id.eq(id)) }) {
        it[description] = newDesc
    }
}

fun checkIfRoomExist(id: Int) = transaction {
    return@transaction RoomEntity.findById(id) != null
}

fun getRoomDescriptionMaxLength() = Rooms.description.maxLength()

fun addFacility(facilityType: FacilitiesTypes) = transaction {
    return@transaction Facilities.insert {
        it[type] = facilityType
        it[isActive] = true
    }
}

fun isFacilityExist(id: Int) = transaction {
    return@transaction FacilityEntity.findById(id) != null
}

fun isFacilityActive(id: Int) = transaction {
    return@transaction FacilityEntity.findById(id)?.isActive ?: false
}

fun deleteFacility(id: Int) = transaction {
    return@transaction Facilities.update({ Facilities.id.eq(id) }) {
        it[isActive] = false
    }
}

fun isFacilityReservationActive(id: Int) = transaction {
    return@transaction FacilityReservationEntity.findById(id)?.isCanceled?.not() ?: false
}

fun deleteReservationFacility(id: Int) = transaction {
    return@transaction FacilitiesReservations.update({ FacilitiesReservations.id.eq(id) }) {
        it[is_canceled] = true
    }
}

fun findFacilityReservation(startDate: Long, endDate: Long, facilityType: Int, roomId: Int): String? = transaction {
    return@transaction FacilityReservationEntity.wrapRows(FacilitiesReservations.select {
        FacilitiesReservations.start_timestamp.eq(startDate)
                .and(FacilitiesReservations.room_id.eq(roomId))
                .and(FacilitiesReservations.is_canceled.eq(false))
                .and(FacilitiesReservations.end_timestamp.eq(endDate))
                .and(FacilitiesReservations.facility_type.eq(facilityType))
    }).toList().firstOrNull()?.id?.value?.toString()

}

fun createReservation(_startDate: Long, _endDate: Long, _roomId: Int, _facilityType: FacilitiesTypes, _facilityId: Int) =
        FacilityReservationEntity.new {
            startDate = _startDate
            endDate = _endDate
            roomId = RoomEntity.findById(_roomId)?.id ?: return@new/*Rooms.select { Rooms.id.eq(1) }.*/
            facilityType = _facilityType.ordinal
            isCanceled = false
            facilityId = FacilityEntity.findById(_facilityId)?.id ?: return@new
        }


//ENDPOINTS
suspend fun PipelineContext<Unit, ApplicationCall>.handleGetAllRoomsGet() {
    call.respond(getAllRooms())
}

suspend fun PipelineContext<Unit, ApplicationCall>.handleGetAllFacilities() {
    call.respond(getAllFacilities())
}

suspend fun PipelineContext<Unit, ApplicationCall>.handleUpdateRoomDescriptionPost() {
    val id = call.parameters["id"]
    val desc = call.parameters["desc"]

    if (id.isNullOrEmpty()) {
        error(ResponseErrorCode.UpdateDescIdNull(call.request.uri))
        return
    }

    if (desc == null) {
        error(ResponseErrorCode.UpdateDescDescriptionNull(call.request.uri))
        return
    }

    if (desc.length > getRoomDescriptionMaxLength()) {
        error(ResponseErrorCode.UpdateDescTooLongDescription(call.request.uri))
        return
    }

    if (!checkIfRoomExist(id.toInt())) {
        error(ResponseErrorCode.UpdateDescNoRoom(call.request.uri))
        return
    }

    updateRoomDesc(id.toInt(), desc)
    call.respond(mapOf("status" to "success"))
}

suspend fun PipelineContext<Unit, ApplicationCall>.handleAddFacilityPost() {
    val post = call.receive<PostAddFacility>()
    val facilityType = FacilitiesTypes.values().find { it.ordinal == post.facility_type } ?: run {
        error(ResponseErrorCode.AddFacilityTypeError(call.request.uri))
        return@handleAddFacilityPost
    }

    addFacility(facilityType)

    call.respond(mapOf("status" to "success"))
}

suspend fun PipelineContext<Unit, ApplicationCall>.handleFacilityDelete() {
    val id = call.parameters["id"]

    if (id.isNullOrEmpty()) {
        error(ResponseErrorCode.DeleteFacilityIdNull(call.request.uri))
        return
    }

    if (!isFacilityExist(id.toInt())) {
        error(ResponseErrorCode.DeleteFacilityNoRoom(call.request.uri))
        return
    }

    if (!isFacilityActive(id.toInt())) {
        error(ResponseErrorCode.DeleteFacilityIsAlreadyDeleted(call.request.uri))
        return
    }

    deleteFacility(id.toInt())
    call.respond(mapOf("status" to "success"))
}

suspend fun PipelineContext<Unit, ApplicationCall>.handleFacilityReservationCancel() {
    val postBody = call.receive<PostAddFacilityReservation>()
    val startDate = postBody.start_date ?: run {
        error(ResponseErrorCode.FacilityReservationMissedBody(call.request.uri))
        return@handleFacilityReservationCancel
    }
    val endDate = postBody.end_date ?: run {
        error(ResponseErrorCode.FacilityReservationMissedBody(call.request.uri))
        return@handleFacilityReservationCancel
    }
    val facilityType = FacilitiesTypes.values().find { it.ordinal == postBody.facility_type } ?: run {
        error(ResponseErrorCode.FacilityReservationMissedBody(call.request.uri))
        return@handleFacilityReservationCancel
    }
    val roomId = postBody.room_id ?: run {
        error(ResponseErrorCode.FacilityReservationMissedBody(call.request.uri))
        return@handleFacilityReservationCancel
    }
    val id = findFacilityReservation(startDate, endDate, facilityType.ordinal, roomId)

    if (id == null) {
        error(ResponseErrorCode.CancelFacilityNoExist(call.request.uri))
        return
    }

    if (!isFacilityReservationActive(id.toInt())) {
        error(ResponseErrorCode.CancelFacilityAlreadyCanceled(call.request.uri))
        return
    }

    deleteReservationFacility(id.toInt())
    call.respond(mapOf("status" to "success"))
}

suspend fun PipelineContext<Unit, ApplicationCall>.addFacilityReservationPost() {
    val postBody = call.receive<PostAddFacilityReservation>()
    val startDate = postBody.start_date ?: run {
        error(ResponseErrorCode.FacilityReservationMissedBody(call.request.uri))
        return@addFacilityReservationPost
    }
    val endDate = postBody.end_date ?: run {
        error(ResponseErrorCode.FacilityReservationMissedBody(call.request.uri))
        return@addFacilityReservationPost
    }
    val roomId = postBody.room_id ?: run {
        error(ResponseErrorCode.FacilityReservationMissedBody(call.request.uri))
        return@addFacilityReservationPost
    }
    val facilityType = FacilitiesTypes.values().find { it.ordinal == postBody.facility_type } ?: run {
        error(ResponseErrorCode.FacilityReservationMissedBody(call.request.uri))
        return@addFacilityReservationPost
    }
    if (!checkIfRoomExist(roomId)) {
        error(ResponseErrorCode.FacilityReservationNoRoomBody(call.request.uri))
        return
    }
    if (endDate < startDate) {
        error(ResponseErrorCode.FacilityReservationMissedBody(call.request.uri))
        return
    }

    val transaction = transaction<Boolean> {
        val query = "SELECT id FROM Facilities facilities WHERE type = ${facilityType.ordinal} AND isActive = TRUE AND NOT EXISTS (" +
                " SELECT reservation.facility_id FROM FacilitiesReservations reservation" +
                " WHERE reservation.facility_id = facilities.id " +
                " AND reservation.is_canceled = FALSE " +
                " AND (" +
                " (reservation.start_date >= $startDate AND reservation.end_date <= $endDate)" +
                " OR" +
                " ($startDate <= reservation.start_date AND $endDate >= reservation.start_date)" +
                " OR" +
                " ($endDate >= reservation.end_date AND $startDate <= reservation.end_date)" +
                " OR" +
                " ($startDate >= reservation.start_date AND $endDate <= reservation.end_date)" +
                " ) LIMIT 1" +
                " ) LIMIT 1;"
        val exec = TransactionManager.current().exec(query) { resultSet ->
            val isFacilityInResult = resultSet.next()
            if (isFacilityInResult) {
                val facilityId = resultSet.getString("id")
                createReservation(startDate, endDate, roomId, facilityType, facilityId.toInt())
                return@exec true
            } else {
                return@exec false
            }
        }
        return@transaction exec ?: false
    }
    if (transaction) {
        call.respond(mapOf("status" to "success"))
    } else {
        call.respond(mapOf("status" to "failed"))
    }
}

private suspend fun PipelineContext<Unit, ApplicationCall>.error(requestError: ResponseErrorCode) {
    call.respond(HttpStatusCode(ResponseErrorCode.EXTERNAL_ERROR_CODE, ResponseErrorCode.EXTERNAL_ERROR_CODE_MESSAGE), requestError)
}
