package utills

import io.ktor.http.HttpStatusCode

sealed class ResponseErrorCode(private val request: String, private val message: String, private val code: HttpStatusCode) {

    class UpdateDescTooLongDescription(request: String) : ResponseErrorCode(request, UPDATE_ROOM_DESC_TOO_LONG_MESSAGE, HttpStatusCode(UPDATE_ROOM_DESC_TOO_LONG_INTERNAL_CODE, UPDATE_ROOM_DESC_TOO_LONG_DESC))
    class UpdateDescDescriptionNull(request: String) : ResponseErrorCode(request, UPDATE_ROOM_DESC_NULL_MESSAGE, HttpStatusCode(UPDATE_ROOM_DESC_NULL_INTERNAL_CODE, UPDATE_ROOM_DESC_NULL_DESC))
    class UpdateDescIdNull(request: String) : ResponseErrorCode(request, UPDATE_ROOM_DESC_ID_NULL_MESSAGE, HttpStatusCode(UPDATE_ROOM_DESC_ID_NULL_INTERNAL_CODE, UPDATE_ROOM_DESC_ID_NULL_DESC))
    class UpdateDescNoRoom(request: String) : ResponseErrorCode(request, UPDATE_ROOM_DESC_NO_ROOM_MESSAGE, HttpStatusCode(UPDATE_ROOM_DESC_NO_ROOM_INTERNAL_CODE, UPDATE_ROOM_DESC_NO_ROOM_DESC))
    class AddFacilityTypeError(request: String) : ResponseErrorCode(request, ADD_FACILITY_NO_GIVEN_TYPE_MESSAGE, HttpStatusCode(ADD_FACILITY_NO_GIVEN_TYPE_INTERNAL_CODE, ADD_FACILITY_NO_GIVEN_TYPE_DESC))
    class DeleteFacilityIdNull(request: String) : ResponseErrorCode(request, DELETE_FACILITY_ID_NULL_MESSAGE, HttpStatusCode(DELETE_FACILITY_ID_NULL_INTERNAL_CODE, DELETE_FACILITY_ID_NULL_DESC))
    class DeleteFacilityNoRoom(request: String) : ResponseErrorCode(request, DELETE_FACILITY_NO_FACILITY_MESSAGE, HttpStatusCode(DELETE_FACILITY_NO_FACILITY_INTERNAL_CODE, DELETE_FACILITY_NO_FACILITY_DESC))
    class DeleteFacilityIsAlreadyDeleted(request: String) : ResponseErrorCode(request, DELETE_FACILITY_ALREADY_DELETED_MESSAGE, HttpStatusCode(DELETE_FACILITY_ALREADY_DELETED_INTERNAL_CODE, DELETE_FACILITY_ALREADY_DELETED__DESC))
    class FacilityReservationMissedBody(request: String) : ResponseErrorCode(request, FACILITY_RESERVATION_MISSED_BODY_VALUES_MESSAGE, HttpStatusCode(FACILITY_RESERVATION_MISSED_INTERNAL_CODE, FACILITY_RESERVATION_MISSED_DELETED__DESC))
    class FacilityReservationNoRoomBody(request: String) : ResponseErrorCode(request, FACILITY_RESERVATION_NO_ROOM_MESSAGE, HttpStatusCode(FACILITY_RESERVATION_NO_ROOM_INTERNAL_CODE, FACILITY_RESERVATION_NO_ROOM_DESC))

    companion object {
        const val EXTERNAL_ERROR_CODE = 418
        const val EXTERNAL_ERROR_CODE_MESSAGE = "Bad request"

        private const val UPDATE_ROOM_DESC_TOO_LONG_MESSAGE = "Too long description, max 50 chars."
        private const val UPDATE_ROOM_DESC_TOO_LONG_INTERNAL_CODE = 400
        private const val UPDATE_ROOM_DESC_TOO_LONG_DESC = "Internal Server Error"

        private const val UPDATE_ROOM_DESC_NULL_MESSAGE = "New description can not be null."
        private const val UPDATE_ROOM_DESC_NULL_INTERNAL_CODE = 401
        private const val UPDATE_ROOM_DESC_NULL_DESC = "Internal Server Error"

        private const val UPDATE_ROOM_DESC_ID_NULL_MESSAGE = "Room ID can not be null."
        private const val UPDATE_ROOM_DESC_ID_NULL_INTERNAL_CODE = 402
        private const val UPDATE_ROOM_DESC_ID_NULL_DESC = "Internal Server Error"

        private const val UPDATE_ROOM_DESC_NO_ROOM_MESSAGE = "No room with given id."
        private const val UPDATE_ROOM_DESC_NO_ROOM_INTERNAL_CODE = 403
        private const val UPDATE_ROOM_DESC_NO_ROOM_DESC = "Internal Server Error"

        private const val ADD_FACILITY_NO_GIVEN_TYPE_MESSAGE = "Incorrect facility type format, or there is no facility type."
        private const val ADD_FACILITY_NO_GIVEN_TYPE_INTERNAL_CODE = 404
        private const val ADD_FACILITY_NO_GIVEN_TYPE_DESC = "Internal Server Error"

        private const val DELETE_FACILITY_ID_NULL_MESSAGE = "Facility ID can not be null."
        private const val DELETE_FACILITY_ID_NULL_INTERNAL_CODE = 405
        private const val DELETE_FACILITY_ID_NULL_DESC = "Internal Server Error"

        private const val DELETE_FACILITY_NO_FACILITY_MESSAGE = "No facility with given id."
        private const val DELETE_FACILITY_NO_FACILITY_INTERNAL_CODE = 406
        private const val DELETE_FACILITY_NO_FACILITY_DESC = "Internal Server Error"

        private const val DELETE_FACILITY_ALREADY_DELETED_MESSAGE = "This facility is already deleted."
        private const val DELETE_FACILITY_ALREADY_DELETED_INTERNAL_CODE = 407
        private const val DELETE_FACILITY_ALREADY_DELETED__DESC = "Internal Server Error"

        private const val FACILITY_RESERVATION_MISSED_BODY_VALUES_MESSAGE = "Body is not valid."
        private const val FACILITY_RESERVATION_MISSED_INTERNAL_CODE = 408
        private const val FACILITY_RESERVATION_MISSED_DELETED__DESC = "Internal Server Error"

        private const val FACILITY_RESERVATION_NO_ROOM_MESSAGE = "No room with given id."
        private const val FACILITY_RESERVATION_NO_ROOM_INTERNAL_CODE = 409
        private const val FACILITY_RESERVATION_NO_ROOM_DESC = "Internal Server Error"
    }
}

