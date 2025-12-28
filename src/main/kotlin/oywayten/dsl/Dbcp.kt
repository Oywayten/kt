package oywayten.dsl

import org.apache.commons.dbcp2.BasicDataSource
import oywayten.dsl.Dbcp.Builder.poolOf

class Dbcp private constructor() : BasicDataSource() {

    companion object Builder {
        private var driverClassName: String = ""
        private var url: String = ""
        private var userName: String = ""
        private var password: String = ""
        private var minIdle: Int = 0
        private var maxIdle: Int = 0
        private var maxOpenPreparedStatements: Int = 0

        fun driverClassName(supplier: () -> String) {
            driverClassName = supplier()
        }

        fun url(supplier: () -> String) {
            url = supplier()
        }

        fun userName(supplier: () -> String) {
            userName = supplier()
        }

        fun password(supplier: () -> String) {
            password = supplier()
        }

        fun minIdle(supplier: () -> Int) {
            this.minIdle = supplier()
        }

        fun maxIdle(supplier: () -> Int) {
            this.maxIdle = supplier()
        }

        fun maxOpenPreparedStatements(supplier: () -> Int) {
            this.maxOpenPreparedStatements = supplier()
        }

        fun build(): Dbcp = Dbcp().apply {
            driverClassName = Dbcp.driverClassName
            url = Dbcp.url
            username = Dbcp.userName
            password = Dbcp.password
            minIdle = Dbcp.minIdle
            maxIdle = Dbcp.maxIdle
            maxOpenPreparedStatements = Dbcp.maxOpenPreparedStatements
        }

        fun poolOf(body: Builder.() -> Dbcp): Dbcp =
            body()
    }


    override fun toString(): String {
        return buildString {
            appendLine("Dbcp {")
            appendLine("driverClassName: ${super.driverClassName}")
            appendLine("url: ${super.url}")
            appendLine("userName: ${super.getUsername()}")
            appendLine("password: ${super.password}")
            appendLine("minIdle: ${super.minIdle}")
            appendLine("maxIdle: ${super.maxIdle}")
            appendLine("maxOpenPreparedStatements: ${super.maxOpenPreparedStatements}")
            appendLine('}')
        }
    }


}


@Suppress("MagicNumber")
fun main() {
    val pool: Dbcp = poolOf {
        driverClassName { "org.postgres.Driver" }
        url { "localhost" }
        userName { "postgres" }
        password { "password" }
        minIdle { 5 }
        maxIdle { 10 }
        maxOpenPreparedStatements { 100 }
        build()
    }

    println(pool)
}

