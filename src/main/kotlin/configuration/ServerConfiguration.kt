package configuration

import RequestError
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.features.StatusPages
import io.ktor.gson.gson
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.util.error
import org.jetbrains.exposed.sql.Database
import java.text.DateFormat

fun Application.configure() = this.apply {
    connectToDatabase()
    installDefaultHeaders()
    installCallLogging()
    installStatusPages()
    installContentNegotiation()
}

private fun Application.installDefaultHeaders() = this.apply { install(DefaultHeaders) }
private fun Application.installCallLogging() = this.apply { install(CallLogging) }
private fun Application.installStatusPages() = this.apply {
    install(StatusPages) {
        exception<Throwable> { cause ->
            environment.log.error(cause)
            val error = RequestError(code = HttpStatusCode.InternalServerError, request = call.request.local.uri, message = cause.toString(), cause = cause)
            call.respond(error)
        }
    }
}

private fun Application.installContentNegotiation() = this.apply {
    install(ContentNegotiation) {
        gson {
            setDateFormat(DateFormat.LONG)
            setPrettyPrinting()
        }
    }
}

private fun Application.connectToDatabase() = this.apply {
    Database.connect()
}

const val SERVER_DEFAULT_PORT = 8095
