import configuration.SERVER_DEFAULT_PORT
import configuration.configure
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import utills.createDataSet


fun main(args: Array<String>) {
    embeddedServer(Netty, SERVER_DEFAULT_PORT) {
        configure()
        roomServiceEndpoints()
//        createDataSet()
    }.apply {
        start(wait = true)
    }
}
