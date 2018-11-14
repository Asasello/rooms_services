import io.ktor.http.HttpStatusCode

data class RequestError(
        val request: String,
        val message: String,
        val code: HttpStatusCode,
        val cause: Throwable? = null
)

data class Room(
        val id: Int,
        val number: Int,
        val floor: Int,
        val description: String,
        val capacity: Int
)

data class Facility(
        val id: Int,
        val type: Int,
        val isActive: Boolean
)

data class PostAddFacility(val facility_type: Int?)

data class PostAddFacilityReservation(val start_date: Long?, val end_date: Long?, val room_id: Int?, val facility_type: Int?)

data class PostCancelReservation(val reservation_id: Int)
