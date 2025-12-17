package oywayten.oop

class HtmlTable {
    fun create(row: Int, cell: Int): String {
        return StringBuilder().apply {
            append("<table>")
            appendRowsWithCells(row, cell)
            append("\n</table>")
        }.toString()
    }

    private fun StringBuilder.appendRowsWithCells(row: Int, cell: Int) {
        repeat(row) {
            append("\n    <tr>")
            appendCells(cell)
            append("\n    </tr>")
        }
    }

    private fun StringBuilder.appendCells(cell: Int) {
        repeat(cell) {
            append("\n        <td></td>")
        }
    }

}
