package oywayten

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Suppress("unused")
class DrawTest {

    @ParameterizedTest
    @MethodSource("getValidDrawArguments")
    fun drawViaForWhenSizeIsValid(size: Int, expected: String) {
        val actual: String = draw(size)
        assertThat(actual).isEqualTo(expected)
    }

    fun getValidDrawArguments(): List<Arguments> {
        return listOf(
            Arguments.of(
                3,
                """
                X X
                 X 
                X X
                """.trimIndent()
            ),
            Arguments.of(
                1,
                """
                X
                """.trimIndent()
            )
        )
    }

    @ParameterizedTest
    @MethodSource("getInvalidDrawArguments")
    fun drawViaForWhenSizeIsInvalid(size: Int) {
        assertThatThrownBy { draw(size) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
    }

    private fun getInvalidDrawArguments(): List<Arguments> {
        return listOf(
            Arguments.of(4),
            Arguments.of(-1),
            Arguments.of(2)
        )
    }

}
