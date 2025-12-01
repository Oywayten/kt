package vitaliy.grab

fun draw(size: Int): String {
    validate(size)

    val sb = StringBuilder()
    for (i in 0 until size) {
        for (j in 0 until size) {
            val x: Char = if (j == i || i == size - j - 1) 'X' else ' '
            sb.append(x)
        }

        if (i < size - 1) {
            sb.appendLine()
        }
    }

    return sb.toString()
}

private fun validate(size: Int) =
    require(size > 0 && size % 2 != 0) { "Size must be odd number greater than 0" }
