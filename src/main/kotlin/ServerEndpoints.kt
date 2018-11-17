import io.ktor.application.Application
import io.ktor.routing.delete
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing


fun Application.roomServiceEndpoints() {
    routing {
        get("/get-all-rooms") {
            handleGetAllRoomsGet()
        }
        get("/get-all-facilities") {
            handleGetAllFacilities()
        }
        post("/update-room-desc{id}{desc}") {
            handleUpdateRoomDescriptionPost()
        }
        post("/add-facility") {
            handleAddFacilityPost()
        }
        delete("/delete-facility{id}") {
            handleFacilityDelete()
        }
        post("/add-facility-reservation") {
            addFacilityReservationPost()
        }
        post("/cancel-facility-reservation"){
            handleFacilityReservationCancel()
        }
    }
}