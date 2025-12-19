package oywayten.safe

import org.assertj.core.api.Assertions.assertThat
import java.time.Instant
import java.util.*
import kotlin.test.Test

class PurchaseTest {

    @Test
    fun htmlTableWhenAddressIsNotNull() {
        val purchase = Purchase(
            "purchase1",
            Date.from(Instant.parse("2007-12-02T10:15:30.00Z")),
            Address("Main street", "That home", "12321")
        )

        val actualTable = htmlTable(purchase)
        val expectedTable = getExpectedTableWithAddress()
        assertThat(actualTable).isEqualTo(expectedTable)
    }

    private fun getExpectedTableWithAddress(): String = """
                <table>
                  <thead>
                    <th>
                      name
                    </th>
                    <th>
                      created
                    </th>
                    <th>
                      address
                    </th>
                  </thead>
                    <tr>
                      <td>purchase1</td>
                      <td>2007-12-02 10:15:30</td>
                      <td>12321, Main street, That home</td>
                    </tr>
                </table>
            """.trimIndent()

    @Test
    fun htmlTableWhenAddressIsNull() {
        val purchase = Purchase(
            "purchase1",
            Date.from(Instant.parse("2007-12-02T10:15:30.00Z"))
        )

        val actualTable = htmlTable(purchase)
        val expectedTable = getExpectedTableWithoutAddress()
        assertThat(actualTable).isEqualTo(expectedTable)
    }

    private fun getExpectedTableWithoutAddress(): String = """
                <table>
                  <thead>
                    <th>
                      name
                    </th>
                    <th>
                      created
                    </th>
                    <th>
                      address
                    </th>
                  </thead>
                    <tr>
                      <td>purchase1</td>
                      <td>2007-12-02 10:15:30</td>
                      <td>unknown address</td>
                    </tr>
                </table>
            """.trimIndent()

}
