package oywayten.safe

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.TimeZone.getTimeZone

private const val ONE_ROW = 1

val formatter: DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").apply {
    this.timeZone = getTimeZone("UTC")
}

data class Address(val street: String, val home: String, val zip: String) {
    override fun toString(): String {
        return "$zip, $street, $home"
    }
}

@Suppress("unused")
class Purchase(val name: String, val created: Date, val address: Address? = null)

fun htmlTable(purchase: Purchase): String {
    return StringBuilder().apply {
        append("<table>")
        appendHeader(purchase)
        appendRowsWithCells(ONE_ROW, purchase)
        append("\n</table>")
    }.toString()
}

private fun StringBuilder.appendHeader(purchase: Purchase) {
    append(
        """
  <thead>"""
    )
    appendHeadersCells(purchase)
    append(
        """
  </thead>"""
    )
}

private fun StringBuilder.appendHeadersCells(purchase: Purchase) {
    getDeclaredFieldsNames(purchase).forEach {
        append("\n    <th>\n")
        append("      $it")
        append("\n    </th>")
    }
}

private fun getDeclaredFieldsNames(purchase: Purchase): List<String> =
    purchase::class.java.declaredFields.map { it.name }

private fun StringBuilder.appendRowsWithCells(row: Int, purchase: Purchase) {
    repeat(row) {
        append("\n    <tr>")
        appendCells(purchase)
        append("\n    </tr>")
    }
}

private fun StringBuilder.appendCells(purchase: Purchase) {
    getDeclaredFieldsNames(purchase)
        .map { purchase::class.java.getDeclaredField(it) }
        .map {
            it.trySetAccessible()
            val fieldValue = it[purchase]
            if (it.type == Date::class.java) formatter.format(fieldValue)
            else fieldValue?.toString()
                ?: "unknown address"
        }
        .forEach { append("\n      <td>${it}</td>") }
}
