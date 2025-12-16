package oywayten

fun add(first: Int, second: Int): Int {
    return first + second
}

fun subtract(first: Int, second: Int): Int {
    return first - second
}

fun divide(first: Int, second: Int): Int = first / second

fun multiply(first: Int, second: Int): Int = first * second

fun max(first: Int, second: Int): Int = if (first >= second) first else second

fun max(first: Int, second: Int, third: Int): Int {
    val max: Int = max(second, third)
    return if (first > max) first else max
}
