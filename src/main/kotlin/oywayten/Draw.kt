package oywayten

fun draw(size: Int): String {
    validate(size)

    return buildString {
        repeat(size) { i ->
            repeat(size) { j ->
                val x: Char = if (j == i || i == size - j - 1) 'X' else ' '
                append(x)
            }

            if (i < size - 1) {
                appendLine()
            }
        }
    }
}

private fun validate(size: Int) =
    require(size > 0 && size % 2 != 0) { "Size must be odd number greater than 0" }
