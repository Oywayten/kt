package vitaliy.grab.oop

class Student(
    var name: String = "not_specified",
    var surname: String = "not_specified",
    var phone: String = "not_specified",
    var email: String = "not_specified"
) {
    private fun asString(): String =
        "Student { name = $name, surname = $surname, phone = $phone, email = $email }"

    fun show() =
        println(asString())
}
