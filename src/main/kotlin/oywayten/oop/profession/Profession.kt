package oywayten.oop.profession

open class Person(private val name: String) {
    open fun getName(): String {
        return name
    }
}

@Suppress("UnusedPrivateProperty")
open class Profession(name: String, val professionName: String, experience: Int) : Person(name) {
    open fun action() {
        println("execute some actions")
    }

    override fun getName(): String {
        return "$professionName ${super.getName()}"
    }

}

@Suppress("UnusedPrivateProperty")
class Student(name: String, professionName: String, experience: Int, group: String, university: String) :
    Profession(name, professionName, experience) {
    override fun action() {
        super.action()
        println("action from student")
    }

    override fun getName(): String {
        return "$professionName ${super.getName()}"
    }
}

@Suppress("UnusedPrivateProperty")
open class Employee(name: String, professionName: String, experience: Int, prevExperience: Map<String, Int>) :
    Profession(name, professionName, experience) {
    override fun action() {
        super.action()
        println("action from employee")
    }

    override fun getName(): String {
        return "Employee $professionName ${super.getName()}"
    }
}

@Suppress("UnusedPrivateProperty")
class Doctor(
    name: String,
    professionName: String,
    experience: Int,
    prevExperience: Map<String, Int>,
    specialization: String,
    medicalInstitution: String
) : Employee(name, professionName, experience, prevExperience) {
    override fun action() {
        super.action()
        println("action from doctor")
    }

    override fun getName(): String {
        return "Doctor ${super.getName()}"
    }
}

@Suppress("UnusedPrivateProperty")
class Driver(
    name: String,
    professionName: String,
    experience: Int,
    prevExperience: Map<String, Int>,
    category: String
) : Employee(name, professionName, experience, prevExperience) {
    override fun action() {
        super.action()
        println("action from driver")
    }

    override fun getName(): String {
        return "Driver ${super.getName()}"
    }
}

@Suppress("UnusedPrivateProperty")
class Diver(
    name: String,
    professionName: String,
    experience: Int,
    prevExperience: Map<String, Int>,
    specialization: String
) : Employee(name, professionName, experience, prevExperience) {
    override fun action() {
        super.action()
        println("action from diver")
    }

    override fun getName(): String {
        return "Diver ${super.getName()}"
    }
}

@Suppress("UnusedPrivateProperty")
class Builder(
    name: String,
    professionName: String,
    experience: Int,
    prevExperience: Map<String, Int>,
    specialization: String
) : Employee(name, professionName, experience, prevExperience) {
    override fun action() {
        super.action()
        println("action from builder")
    }

    override fun getName(): String {
        return "Builder ${super.getName()}"
    }
}
