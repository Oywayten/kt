package oywayten

import java.util.*

const val SIMPLE_NUM = 31

data class Stock(val name: String, val currency: Currency, val date: Date) {

    override fun equals(other: Any?): Boolean {
        if (other === this) return true
        if (other !is Stock) return false

        return name == other.name &&
                currency == other.currency &&
                date == other.date
    }

    override fun hashCode(): Int =
        SIMPLE_NUM + name.hashCode() + SIMPLE_NUM + currency.hashCode() + SIMPLE_NUM + date.hashCode()

}
