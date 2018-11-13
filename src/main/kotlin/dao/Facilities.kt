package dao

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object Facilities : IntIdTable() {
    val type = enumeration("type", FacilitiesTypes::class)
    val isActive = bool("isActive")
}

class FacilityEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<FacilityEntity>(Facilities)

    var type by Facilities.type
    var isActive by Facilities.isActive
}