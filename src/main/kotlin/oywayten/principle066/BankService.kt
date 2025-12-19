package oywayten.principle066

data class User(val passport: String, val name: String)
data class Account(var requisite: String, var balance: Double)

@Suppress("unused")
class BankService {

    private val users = mutableMapOf<User, MutableList<Account>>()

    fun addUser(user: User) {
        users.putIfAbsent(user, mutableListOf())
    }

    fun findByPassport(passport: String): User? =
        users.keys.firstOrNull { it.passport == passport }

    fun findByRequisite(passport: String, requisite: String): Account? =
        findByPassport(passport).let { user ->
            users[user]?.firstOrNull { it.requisite == requisite }
        }

    fun addAccount(passport: String, account: Account) {
        findByPassport(passport).let { users[it]?.add(account) }
    }

    fun transferMoney(
        srcPassport: String,
        srcRequisite: String,
        destPassport: String,
        destRequisite: String,
        amount: Double
    ): Boolean {
        val source = findByRequisite(srcPassport, srcRequisite)
        val dest = findByRequisite(destPassport, destRequisite)
        val rsl = source != null && dest != null
        if (rsl) {
            source.balance = source.balance - amount
            dest.balance = dest.balance + amount
        }
        return rsl
    }
}
