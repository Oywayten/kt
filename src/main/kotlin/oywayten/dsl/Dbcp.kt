package oywayten.dsl

import org.apache.commons.dbcp2.BasicDataSource
import oywayten.dsl.Dbcp.Builder.credential
import oywayten.dsl.Dbcp.Builder.driverClassName
import oywayten.dsl.Dbcp.Builder.maxIdle
import oywayten.dsl.Dbcp.Builder.maxOpenPreparedStatements
import oywayten.dsl.Dbcp.Builder.minIdle
import oywayten.dsl.Dbcp.Builder.poolOf
import oywayten.dsl.Dbcp.Builder.url

class Dbcp private constructor() : BasicDataSource() {


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

    companion object Builder {
        var driverClass: String = ""
        var url: String = ""
        var username: String = ""
        var password: String = ""
        var minIdle: Int = 0
        var maxIdle: Int = 0
        var maxOpenPreparedStatements: Int = 0

        fun poolOf(builderBody: Dbcp.() -> Unit): Dbcp = Dbcp().apply {
            builderBody()
        }.setFromBuilder()


        fun driverClassName(supplier: () -> String) {
            driverClass = supplier()
        }

        fun url(supplier: () -> String) {
            url = supplier()
        }

        fun credential(body: Builder.() -> Unit) {
            body(this)
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

        fun Dbcp.setFromBuilder(): Dbcp = apply {
            driverClassName = Builder.driverClass
            url = Builder.url
            username = Builder.username
            password = Builder.password
            minIdle = Builder.minIdle
            maxIdle = Builder.maxIdle
            maxOpenPreparedStatements = Builder.maxOpenPreparedStatements
        }
    }

}


@Suppress("MagicNumber")
fun main() {
    val pool: Dbcp = poolOf {
        driverClassName { "org.db.CustomDriver" }
        url { "localhost" }
        credential { password = "postgres"; username = "postgres" }
        minIdle { 5 }
        maxIdle { 10 }
        maxOpenPreparedStatements { 100 }
    }

    println(pool)
}

