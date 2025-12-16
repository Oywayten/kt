package oywayten.oop

class Student(
    var name: String = "not_specified",
    var surname: String = "not_specified",
    var phone: String = "not_specified",
    var email: String = "not_specified"
) {
    override fun toString(): String =
        "Student { name = $name, surname = $surname, phone = $phone, email = $email }"

    fun show():Unit =
        println(toString())
}
