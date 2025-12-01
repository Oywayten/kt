package vitaliy.grab.oop

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StudentTest {

    @ParameterizedTest
    @MethodSource("getStudents")
    fun toString(student: Student, expected: String) {

        val actual: String = student.toString()
        assertThat(actual).isEqualTo(expected)
    }

    @Suppress("unused")
    private fun getStudents(): List<Arguments> {
        return listOf(
            Arguments.of(
                Student(name = "Oywayten", email = "oywayten@gmail.com"),
                "Student { name = Oywayten, surname = not_specified, " +
                        "phone = not_specified, email = oywayten@gmail.com }"
            ),
            Arguments.of(
                Student(),
                "Student { name = not_specified, surname = not_specified, " +
                        "phone = not_specified, email = not_specified }"
            ),
            Arguments.of(
                Student(name = "Bob", surname = "Tomson", phone = "+123", email = "1@1.com"),
                "Student { name = Bob, surname = Tomson, phone = +123, email = 1@1.com }"
            )
        )
    }

}
