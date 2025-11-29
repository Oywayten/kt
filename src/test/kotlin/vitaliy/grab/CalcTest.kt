package vitaliy.grab

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Suppress("unused")
class CalcTest {

    @Test
    fun whenAddHasNotExpectedResult() {
        val actual = add(1, 2)
        val expected = 4
        assertThat(actual).isNotEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource
    fun whenAddHasExpectedResult(first: Int, second: Int, expected: Int) {
        val actual = add(first, second)
        assertThat(actual).isEqualTo(expected)
    }

    private fun whenAddHasExpectedResult(): List<Arguments> {
        return listOf(
            Arguments.of(1, 2, 3),
            Arguments.of(5, 7, 12),
            Arguments.of(0, 2, 2),
            Arguments.of(-1, 2, 1)
        )
    }

    @Test
    fun whenSubtractHasNotExpectedResult() {
        val actual = subtract(4, 2)
        val expected = 5
        assertThat(actual).isNotEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource
    fun whenSubtractHasExpectedResult(first: Int, second: Int, expected: Int) {
        val actual = subtract(first, second)
        assertThat(actual).isEqualTo(expected)
    }

    private fun whenSubtractHasExpectedResult(): List<Arguments> {
        return listOf(
            Arguments.of(10, 2, 8),
            Arguments.of(997, 7, 990),
            Arguments.of(0, 2, -2),
            Arguments.of(100, 100, 0),
            Arguments.of(0, 0, 0),
            Arguments.of(-0, 0, 0),
            Arguments.of(-1, 2, -3)
        )
    }

    @Test
    fun whenDivideHasNotExpectedResult() {
        val actual = subtract(4, 2)
        val expected = 5
        assertThat(actual).isNotEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource
    fun whenDivideHasExpectedResult(first: Int, second: Int, expected: Int) {
        val actual = divide(first, second)
        assertThat(actual).isEqualTo(expected)
    }

    private fun whenDivideHasExpectedResult(): List<Arguments> {
        return listOf(
            Arguments.of(10, 2, 5),
            Arguments.of(1393, 7, 199),
            Arguments.of(0, 2, 0),
            Arguments.of(100, 100, 1),
            Arguments.of(14, 7, 2),
            Arguments.of(-0, 1, 0),
            Arguments.of(-4, 2, -2)
        )
    }

    @Test
    fun whenMultiplyHasNotExpectedResult() {
        val actual = multiply(9, 3)
        val expected = 5
        assertThat(actual).isNotEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource
    fun whenMultiplyHasExpectedResult(first: Int, second: Int, expected: Int) {
        val actual = multiply(first, second)
        assertThat(actual).isEqualTo(expected)
    }

    private fun whenMultiplyHasExpectedResult(): List<Arguments> {
        return listOf(
            Arguments.of(10, 2, 20),
            Arguments.of(3, 7, 21),
            Arguments.of(0, 2, 0),
            Arguments.of(100, 100, 10_000),
            Arguments.of(14, 7, 98),
            Arguments.of(-0, 1, 0),
            Arguments.of(-1, 3, -3),
            Arguments.of(-4, 2, -8)
        )
    }

    @Test
    fun whenMax2HasNotExpectedResult() {
        val actual = max(9, 3)
        val expected = 3
        assertThat(actual).isNotEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource
    fun whenMax2HasExpectedResult(first: Int, second: Int, expected: Int) {
        val actual = max(first, second)
        assertThat(actual).isEqualTo(expected)
    }

    private fun whenMax2HasExpectedResult(): List<Arguments> {
        return listOf(
            Arguments.of(10, 2, 10),
            Arguments.of(3, 7, 7),
            Arguments.of(0, 2, 2),
            Arguments.of(100, 100, 100),
            Arguments.of(14, 7, 14),
            Arguments.of(-0, 1, 1),
            Arguments.of(-1, 3, 3),
            Arguments.of(-4, 2, 2)
        )
    }

    @Test
    fun whenMax3HasNotExpectedResult() {
        val actual = max(9, 3, 18)
        val expected = 9
        assertThat(actual).isNotEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource
    fun whenMax3HasExpectedResult(first: Int, second: Int, third: Int, expected: Int) {
        val actual = max(first, second, third)

        assertThat(actual).isEqualTo(expected)
    }

    private fun whenMax3HasExpectedResult(): List<Arguments> {
        return listOf(
            Arguments.of(10, 2, 100, 100),
            Arguments.of(3, 7, 7, 7),
            Arguments.of(100, 1, 2, 100),
            Arguments.of(100, 100, 0, 100),
            Arguments.of(14, 70, 39, 70),
            Arguments.of(-0, 1, 11, 11),
            Arguments.of(-1, 3, -3, 3),
            Arguments.of(-4, 2, -22, 2)
        )
    }

}
