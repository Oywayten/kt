package oywayten

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.TimeZone.getTimeZone

private const val PREFIX = "Campaign{"
private const val POSTFIX = "}"

val formatter: DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").apply {
    this.timeZone = getTimeZone("UTC")
}

data class Campaign(val name: String, val address: Address, val created: Date) {
    data class Address(val simpleAddress: String)

    override fun toString(): String {
        return listOf(
            name,
            address.simpleAddress,
            formatter.format(created)
        ).joinToString(" ", PREFIX, POSTFIX)
    }
}

fun List<Campaign>.toStrings(): List<String> = map { it.toString() }
