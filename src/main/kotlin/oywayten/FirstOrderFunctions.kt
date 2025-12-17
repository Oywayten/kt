package oywayten

private val addd: (Double, Double) -> Double = { left, right -> left + right }
private val subtract: (Double, Double) -> Double = { left, right -> left - right }
private val multiply: (Double, Double) -> Double = { left, right -> left * right }
private val divide: (Double, Double) -> Double = { left, right -> left / right }
private val mod: (Double, Double) -> Double = { left, right -> left % right }

private enum class Operation(val function: (Double, Double) -> Double) {
    ADD(addd),
    SUBTRACT(subtract),
    MULTIPLY(multiply),
    DIVIDE(divide),
    MOD(mod)
}

fun operation(name: String): (Double, Double) -> Double =
    Operation.valueOf(name.uppercase()).function
