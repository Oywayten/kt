package vitaliy.grab

fun draw(size: Int, exec: (Int, StringBuilder) -> Unit): String {
    validateDrawSize(size)
    val sb = StringBuilder()
    exec(size, sb)
    return sb.toString()
}

private fun validateDrawSize(size: Int) {
    require (size > 0 && size % 2 != 0, { "Size must be odd number greater than 0" })
}

private fun getNextChar(j: Int, i: Int, size: Int): Char {
    val x: Char = if (j == i || i == size - j - 1) 'X' else ' '
    return x
}

private fun addNewLine(i: Int, size: Int, sb: StringBuilder) {
    if (i < size - 1) {
        sb.appendLine()
    }
}

fun drawViaFor(size: Int, sb: StringBuilder) {
    for (i in 0 until size) {
        for (j in 0 until size) {
            sb.append(getNextChar(j, i, size))
        }
        addNewLine(i, size, sb)
    }
}

fun drawViaRepeat(size: Int, sb: StringBuilder) {
    repeat(size) { i ->
        repeat(size) { j ->
            sb.append(getNextChar(j, i, size))
        }
        addNewLine(i, size, sb)
    }
}
