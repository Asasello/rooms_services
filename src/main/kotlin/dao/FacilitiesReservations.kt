package dao

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object FacilitiesReservations : IntIdTable() {
    val start_timestamp = long("start_date")
    val end_timestamp = long("end_date")
    val room_id = entityId("room_id", Rooms)
    val facility_id = entityId("facility_id", Facilities)
    val is_canceled = bool("is_canceled")
    val facility_type = integer("facility_type")
}

class FacilityReservationEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<FacilityReservationEntity>(FacilitiesReservations)

    var startDate by FacilitiesReservations.start_timestamp
    var endDate by FacilitiesReservations.end_timestamp
    var roomId by FacilitiesReservations.room_id
    var facilityId by FacilitiesReservations.facility_id
    var isCanceled by FacilitiesReservations.is_canceled
    var facilityType by FacilitiesReservations.facility_type
}