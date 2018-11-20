import configuration.SERVER_DEFAULT_PORT
import configuration.configure
import io.ktor.server.engine.*
import io.ktor.server.netty.*


fun main(args: Array<String>) {
    embeddedServer(Netty, SERVER_DEFAULT_PORT) {
        configure()
        roomServiceEndpoints()
    }.apply {
        start(wait = true)
    }
}
