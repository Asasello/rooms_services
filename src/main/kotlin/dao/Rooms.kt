package dao

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object Rooms : IntIdTable() {
    val number = integer("number")
    val floor = integer("floor")
    val description = varchar("description", 50)
    val capacity = integer("capacity")
}

class RoomEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<RoomEntity>(Rooms)

    var number by Rooms.number
    var floor by Rooms.floor
    var description by Rooms.description
    var capacity by Rooms.capacity
}