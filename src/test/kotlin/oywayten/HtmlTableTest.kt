package oywayten

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import oywayten.oop.HtmlTable

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HtmlTableTest {

    @ParameterizedTest
    @MethodSource("whenCreateDataProvider")
    fun whenCreateIsExpected(row: Int, cell: Int, expected: String) {
        val table = HtmlTable()
        val actual = table.create(row, cell)
        assertThat(actual).isEqualTo(expected)
    }

    @Suppress("unused")
    private fun whenCreateDataProvider(): List<Arguments> =
        listOf(
            arguments(4, 2, getExpected4x2()),
            arguments(
                1, 1, """
                <table>
                    <tr>
                        <td></td>
                    </tr>
                </table>
            """.trimIndent()
            ),
            arguments(
                1, 0, """
                <table>
                    <tr>
                    </tr>
                </table>
            """.trimIndent()
            ),
            arguments(
                0, 1, """
                <table>
                </table>
            """.trimIndent()
            ),
            arguments(
                0, 0, """
                <table>
                </table>
            """.trimIndent()
            ),
        )

    private fun getExpected4x2(): String = """
                <table>
                    <tr>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
            """.trimIndent()

}

