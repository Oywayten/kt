package oywayten

private const val IVAN = "Ivan"

private const val EMPTY_BALANCE = 0

data class Account(val name: String, val balance: Int)

val predicate = { acc: Account -> acc.name == IVAN && acc.balance > EMPTY_BALANCE }
