package oywayten

import java.sql.Connection
import java.sql.DriverManager
import kotlin.system.measureTimeMillis

class SqlExecutor {
    private lateinit var connection: Connection

    fun init(url: String, user: String = "", password: String = "") {
        connection = DriverManager.getConnection(url, user, password)
    }

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
}
