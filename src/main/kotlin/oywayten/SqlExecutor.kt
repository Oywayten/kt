package oywayten

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import kotlin.system.measureTimeMillis

class SqlExecutor : AutoCloseable {
    var isClosed: Boolean = false
    private lateinit var connection: Connection

    fun init(url: String, user: String = "", password: String = "") {
        connection = DriverManager.getConnection(url, user, password)
    }

    @Throws(SQLException::class)
    fun exec(sql: String): String {
        val statement = connection.createStatement()
        return buildString {
            appendLine()
            append("[sql] Start execute sql: $sql").appendLine()

            val millis = measureTimeMillis {
                statement.executeQuery(sql)
            }

            append("[sql] End of script execute: $millis ms")
        }
    }

    override fun close() {
        if (!isClosed) {
            isClosed = true
            connection.close()
        }
    }
}
