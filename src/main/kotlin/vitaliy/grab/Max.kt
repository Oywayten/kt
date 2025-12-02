package vitaliy.grab

fun max(first: Int, second: Int): Int =
    if (first >= second) first else second

fun max(vararg values: Int): Int =
    max(values.toTypedArray())

fun max(ints: Array<Int>): Int {
    require(ints.isNotEmpty())

    var max = ints[0]
    for (i in ints) {
        max = max(max, i)
    }

    return max
}
