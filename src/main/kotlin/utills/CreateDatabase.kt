package utills

import dao.*
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

fun createDataSet() {
    transaction {
        SchemaUtils.drop(Rooms, Facilities, FacilitiesReservations)
        SchemaUtils.create(Rooms, Facilities, FacilitiesReservations)
        dao.Rooms.insert {
            it[number] = 1
            it[floor] = 1
            it[description] = "Room with one bed and TV."
            it[capacity] = 1
        }
        dao.Rooms.insert {
            it[number] = 2
            it[floor] = 1
            it[description] = "Room with one king-size bed and TV."
            it[capacity] = 2
        }
        dao.Rooms.insert {
            it[number] = 3
            it[floor] = 1
            it[description] = "Room with two double bed and TV."
            it[capacity] = 4
        }
        dao.Rooms.insert {
            it[number] = 4
            it[floor] = 1
            it[description] = "Room with one bed, without TV."
            it[capacity] = 1
        }
        dao.Rooms.insert {
            it[number] = 5
            it[floor] = 1
            it[description] = "Room with three beds, without TV."
            it[capacity] = 3
        }
        dao.Rooms.insert {
            it[number] = 6
            it[floor] = 1
            it[description] = "Room with three bed and TV."
            it[capacity] = 3
        }
        dao.Rooms.insert {
            it[number] = 7
            it[floor] = 1
            it[description] = "Room with one king-size bed and TV."
            it[capacity] = 2
        }
        dao.Rooms.insert {
            it[number] = 8
            it[floor] = 1
            it[description] = "Room with two double bed and TV."
            it[capacity] = 4
        }
        dao.Rooms.insert {
            it[number] = 9
            it[floor] = 1
            it[description] = "Room with one bed and TV."
            it[capacity] = 1
        }
        dao.Rooms.insert {
            it[number] = 10
            it[floor] = 1
            it[description] = "Room with two double bed and TV."
            it[capacity] = 4
        }
        dao.Rooms.insert {
            it[number] = 11
            it[floor] = 2
            it[description] = "Room with TV and bathroom."
            it[capacity] = 5
        }
        dao.Rooms.insert {
            it[number] = 12
            it[floor] = 2
            it[description] = "Room with TV and bathroom."
            it[capacity] = 2
        }
        dao.Rooms.insert {
            it[number] = 13
            it[floor] = 2
            it[description] = "Room with bedside lamp, charis, TV."
            it[capacity] = 1
        }
        dao.Rooms.insert {
            it[number] = 14
            it[floor] = 2
            it[description] = "Room with bathroom, chairs, table, free wifi."
            it[capacity] = 4
        }
        dao.Rooms.insert {
            it[number] = 15
            it[floor] = 2
            it[description] = "Room without bathroom."
            it[capacity] = 2
        }
        dao.Rooms.insert {
            it[number] = 16
            it[floor] = 2
            it[description] = "Room with bedside lamp."
            it[capacity] = 2
        }
        dao.Rooms.insert {
            it[number] = 17
            it[floor] = 2
            it[description] = "Room with TV and bathroom."
            it[capacity] = 3
        }
        dao.Rooms.insert {
            it[number] = 18
            it[floor] = 2
            it[description] = "Room with TV and bathroom."
            it[capacity] = 1
        }
        dao.Rooms.insert {
            it[number] = 19
            it[floor] = 2
            it[description] = "Room with chairs, table and TV."
            it[capacity] = 3
        }
        dao.Rooms.insert {
            it[number] = 20
            it[floor] = 2
            it[description] = "Room with TV and bathroom."
            it[capacity] = 4
        }

        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.FLIP_FLOPS
            it[isActive] = true
        }

        dao.Facilities.insert {
            it[type] = FacilitiesTypes.FLIP_FLOPS
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.FLIP_FLOPS
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.KETTLE
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.KETTLE
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.KETTLE
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.KETTLE
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.KETTLE
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.KETTLE
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.ROCKING_CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.ROCKING_CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.TOWEL
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.TOWEL
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.TOWEL
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.TOWEL
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.TOWEL
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.TOWEL
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.TOWEL
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.TOWEL
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.FLIP_FLOPS
            it[isActive] = true
        }

        dao.Facilities.insert {
            it[type] = FacilitiesTypes.FLIP_FLOPS
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.FLIP_FLOPS
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.KETTLE
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.KETTLE
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.KETTLE
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.KETTLE
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.KETTLE
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.KETTLE
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.ROCKING_CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.ROCKING_CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.TOWEL
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.TOWEL
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.TOWEL
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.TOWEL
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.TOWEL
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.TOWEL
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.TOWEL
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.TOWEL
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.FLIP_FLOPS
            it[isActive] = true
        }

        dao.Facilities.insert {
            it[type] = FacilitiesTypes.FLIP_FLOPS
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.FLIP_FLOPS
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.KETTLE
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.KETTLE
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.KETTLE
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.KETTLE
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.KETTLE
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.KETTLE
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.ROCKING_CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.ROCKING_CHAIR
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.TOWEL
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.TOWEL
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.TOWEL
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.TOWEL
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.TOWEL
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.TOWEL
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.TOWEL
            it[isActive] = true
        }
        dao.Facilities.insert {
            it[type] = FacilitiesTypes.TOWEL
            it[isActive] = true
        }

        FacilityReservationEntity.new {
            startDate = 0
            endDate = 100
            roomId = RoomEntity.findById(1)?.id ?: return@new/*Rooms.select { Rooms.id.eq(1) }.*/
            facilityType = FacilitiesTypes.TOWEL.ordinal
            isCanceled = false
            facilityId = FacilityEntity.findById(1)?.id ?: return@new
        }
        FacilityReservationEntity.new {
            startDate = 101
            endDate = 200
            roomId = RoomEntity.findById(1)?.id ?: return@new/*Rooms.select { Rooms.id.eq(1) }.*/
            facilityType = FacilitiesTypes.TOWEL.ordinal
            isCanceled = false
            facilityId = FacilityEntity.findById(1)?.id ?: return@new
        }
        FacilityReservationEntity.new {
            startDate = 301
            endDate = 400
            roomId = RoomEntity.findById(1)?.id ?: return@new/*Rooms.select { Rooms.id.eq(1) }.*/
            facilityType = FacilitiesTypes.TOWEL.ordinal
            isCanceled = false
            facilityId = FacilityEntity.findById(1)?.id ?: return@new
        }
        FacilityReservationEntity.new {
            startDate = 901
            endDate = 1000
            roomId = RoomEntity.findById(1)?.id ?: return@new/*Rooms.select { Rooms.id.eq(1) }.*/
            facilityType = FacilitiesTypes.TOWEL.ordinal
            isCanceled = false
            facilityId = FacilityEntity.findById(1)?.id ?: return@new
        }
        FacilityReservationEntity.new {
            startDate = 1001
            endDate = 2000
            roomId = RoomEntity.findById(1)?.id ?: return@new/*Rooms.select { Rooms.id.eq(1) }.*/
            facilityType = FacilitiesTypes.TOWEL.ordinal
            isCanceled = false
            facilityId = FacilityEntity.findById(1)?.id ?: return@new
        }
    }
}
