package configuration

import org.jetbrains.exposed.sql.Database

private const val DATABASE_URL = "jdbc:mysql://mysql-room-service:3306/room_services_db"
private const val DATABASE_DRIVER = "com.mysql.jdbc.Driver"
private const val DATABASE_USER = "root"
private const val DATABASE_USER_PASSWORD = "Database223344"

fun Database.Companion.connect(databaseUrl: String = DATABASE_URL, databaseDriver: String = DATABASE_DRIVER, databaseUser: String = DATABASE_USER, databaseUserPassword: String = DATABASE_USER_PASSWORD) {
    connect(url = databaseUrl, driver = databaseDriver, user = databaseUser, password = databaseUserPassword)
}
