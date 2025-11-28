package vitaliy.grab

fun add(first : Int, second : Int) : Int {
    return first + second
}

fun subtract(first : Int, second : Int) : Int {
    return first - second
}

fun divide(first: Int, second: Int) = first / second
fun multiply(first: Int, second: Int) = first * second

fun main() {
    val plus = add(1, 1)
    println("1 + 1 = $plus")

    val minus = subtract(1, 1)
    println("1 - 1 = $minus")

    val divide= divide(16, 8)
    println("16 / 8 = $divide")

    val multiply = multiply(3, 7)
    println("3 * 7 = $multiply")
}