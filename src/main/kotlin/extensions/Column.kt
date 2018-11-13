package extensions

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ColumnType
import org.jetbrains.exposed.sql.VarCharColumnType

fun <T : String> Column<T>.maxLength(): Int =
        (columnType as VarCharColumnType).colLength
