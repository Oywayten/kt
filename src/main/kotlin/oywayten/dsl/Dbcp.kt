package oywayten.dsl

import org.apache.commons.dbcp2.BasicDataSource

class Dbcp private constructor() : BasicDataSource() {

    companion object Builder {
        private var driverClassName: String = ""
        private var url: String = ""
        private var userName: String = ""
        private var password: String = ""
        private var minIdle: Int = 0
        private var maxIdle: Int = 0
        private var maxOpenPreparedStatements: Int = 0

        fun driverClassName(driverClassName: String): Builder = apply { this.driverClassName = driverClassName }
        fun url(url: String): Builder = apply { this.url = url }
        fun userName(userName: String): Builder = apply { this.userName = userName }
        fun password(password: String): Builder = apply { this.password = password }
        fun minIdle(minIdle: Int): Builder = apply { this.minIdle = minIdle }
        fun maxIdle(maxIdle: Int): Builder = apply { this.maxIdle = maxIdle }
        fun maxOpenPreparedStatements(maxOpenStatements: Int): Builder =
            apply { this.maxOpenPreparedStatements = maxOpenStatements }

        fun build(): Dbcp = Dbcp().apply {
            driverClassName = Dbcp.driverClassName
            url = Dbcp.url
            username = Dbcp.userName
            password = Dbcp.password
            minIdle = Dbcp.minIdle
            maxIdle = Dbcp.maxIdle
            maxOpenPreparedStatements = Dbcp.maxOpenPreparedStatements
        }
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
    val pool = Dbcp
        .driverClassName("org.postgres.Driver")
        .url("localhost")
        .userName("postgres")
        .password("password")
        .minIdle(5)
        .maxIdle(10)
        .maxOpenPreparedStatements(100)
        .build()
    println(pool)
}


