package oywayten.oop

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class EmailServiceTest {

    @Test
    fun emailTo() {
        val message = Message("Bob", "Hi, there!")
        val actual = EmailService().emailTo(message)
        val expected = "Subject: Hi, there! Body: Hello, Bob You win!"
        assertThat(actual).isEqualTo(expected)
    }

}