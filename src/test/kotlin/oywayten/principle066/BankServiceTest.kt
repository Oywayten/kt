package oywayten.principle066

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.SoftAssertions
import kotlin.test.Test

class BankServiceTest {

    @Test
    fun whenPassportNotFoundThenNull() {
        val bank = BankService()
        bank.addUser(User("321", "Petr Arsentev"))

        val actual = bank.findByPassport("3211")
        assertThat(actual).isNull()
    }

    @Test
    fun whenPassportFoundThenUser() {
        val bank = BankService()
        val name = "Petr Arsentev"
        val user = User("321", name)
        bank.addUser(user)

        val actual = bank.findByPassport("321")

        SoftAssertions.assertSoftly {
            it.assertThat(actual).isNotNull
            it.assertThat(actual?.name).isEqualTo(name)
            it.assertThat(actual).isEqualTo(user)

        }
    }

}
