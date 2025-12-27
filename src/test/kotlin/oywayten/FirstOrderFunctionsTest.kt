package oywayten

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import kotlin.test.Test

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Suppress("unused")
class FirstOrderFunctionsTest {

    private val formatter = DecimalFormat()
        .apply {
            maximumFractionDigits = 2
            isGroupingUsed = false
            decimalFormatSymbols = DecimalFormatSymbols().apply {
                decimalSeparator = '.'
            }

        }

    @ParameterizedTest
    @MethodSource("whenOperationDataProvider")
    fun whenOperationIsExpected(name: String, left: Double, rigth: Double, expected: Double) {
        val operationClosure = operation(name)
        val format = formatter.format(operationClosure(left, rigth))
        println(format)
        val actual = format.toDouble()
        assertThat(actual).isEqualTo(expected)
    }

    private fun whenOperationDataProvider(): List<Arguments> =
        listOf(
            arguments("add", 5.0, 3.0, 8.0),
            arguments("subtract", 5.0, 3.0, 2.0),
            arguments("multiply", 5.0, 3.0, 15.0),
            arguments("multiply", 500.130, 3.0, 1500.39),
            arguments("divide", 5.0, 3.0, 1.67),
            arguments("mod", 5.0, 3.0, 2.0)
        )

    @Test
    fun whenOperationIsNotExpectedThenThrow() {
        assertThatThrownBy { operation("unknown") }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
    }
}
