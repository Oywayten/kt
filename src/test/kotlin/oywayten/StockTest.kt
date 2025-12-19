package oywayten

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.RepeatedTest
import java.time.Instant.parse
import java.util.Currency.getInstance
import java.util.Date.from
import java.util.Locale.US
import kotlin.test.Test

private const val DATE_STRING = "2007-12-02T10:15:30.00Z"

private const val APPLE_NAME = "APPLE"

private val stockX = Stock(APPLE_NAME, getInstance(US), from(parse(DATE_STRING)))
private val stockY = Stock(APPLE_NAME, getInstance(US), from(parse(DATE_STRING)))

class StockTest {

    @Test
    @Suppress("CAN_BE_REPLACED_WITH_OPERATOR")
    fun equalsReflexive() {
        assertThat(stockX.equals(stockX)).isTrue
    }

    @Test
    fun equalsSymmetric() {
        assertThat(stockX == stockY).isEqualTo(stockY == stockX)
    }

    @Test
    fun equalsTransitive() {
        val stockZ = Stock(APPLE_NAME, getInstance(US), from(parse(DATE_STRING)))
        assertThat(stockX == stockY)
            .isEqualTo(stockY == stockZ)
            .isEqualTo(stockX == stockZ)
    }

    @RepeatedTest(50)
    fun equalsConsistent() {
        assertThat(stockX == stockY).isEqualTo(stockY == stockX)
    }

    @Test
    fun equalsNonNull() {
        assertThat(stockX.equals(null)).isFalse
    }

}
