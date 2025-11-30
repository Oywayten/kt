package vitaliy.grab

fun add(first: Int, second: Int): Int =
    first + second

fun subtract(first: Int, second: Int): Int =
    first - second

fun divide(first: Int, second: Int): Int =
    first / second

fun multiply(first: Int, second: Int): Int =
    first * second

fun max(first: Int, second: Int): Int =
    if (first >= second) first else second

fun max(vararg values: Int): Int =
    max(ints = values.toTypedArray())

fun max(ints: Array<Int>): Int {
    require(ints.isNotEmpty())
    return ints.reduce { i, i2 -> max(i, i2) }
}
