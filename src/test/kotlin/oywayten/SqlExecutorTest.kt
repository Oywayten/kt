package oywayten

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class SqlExecutorTest {

    @Test
    fun whenSelect1ExecuteThenLog() {
        val sqlExecutor = SqlExecutor()
        val jdbcURL = "jdbc:h2:mem:test"
        sqlExecutor.init(jdbcURL)
        val actual = sqlExecutor.exec("select 1")
        val expected = """
            
            \[sql] Start execute sql: select 1
            \[sql] End of script execute: \d{1,3} ms
        """.trimIndent()
        assertThat(actual).containsPattern(expected)
    }
}
