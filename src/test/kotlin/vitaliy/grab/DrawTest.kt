package vitaliy.grab

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
        val actual: String = draw(size, ::drawViaFor)
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
        assertThatThrownBy { draw(size, ::drawViaFor) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
    }

    private fun getInvalidDrawArguments(): List<Arguments> {
        return listOf(
            Arguments.of(4),
            Arguments.of(-1),
            Arguments.of(2)
        )
    }

    @ParameterizedTest
    @MethodSource("getValidDrawArguments")
    fun drawViaRepeatWhenSizeIsValid(size: Int, expected: String) {
        val actual: String = draw(size, ::drawViaRepeat)
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("getInvalidDrawArguments")
    fun drawViaRepeatWhenSizeIsInvalid(size: Int) {
        assertThatThrownBy { draw(size, ::drawViaRepeat) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
    }

}
