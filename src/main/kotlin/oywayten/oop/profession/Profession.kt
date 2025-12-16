package oywayten.oop.profession

open class Person(val name : String)

@Suppress("UnusedPrivateProperty")
open class Profession(name: String, experience: Int) : Person(name)

@Suppress("UnusedPrivateProperty")
class Student(name: String, experience: Int, group: String, university: String) : Profession(name, experience)

@Suppress("UnusedPrivateProperty")
open class Employee(name: String, experience: Int, prevExperience: Map<String, Int>) : Profession(name, experience)

@Suppress("UnusedPrivateProperty")
class Doctor(
    name: String,
    experience: Int,
    prevExperience: Map<String, Int>,
    specialization: String,
    medicalInstitution: String
) : Employee(name, experience, prevExperience)

@Suppress("UnusedPrivateProperty")
class Driver(
    name: String,
    experience: Int,
    prevExperience: Map<String, Int>,
    category: String
) : Employee(name, experience, prevExperience)

@Suppress("UnusedPrivateProperty")
class Diver(
    name: String,
    experience: Int,
    prevExperience: Map<String, Int>,
    specialization: String
) : Employee(name, experience, prevExperience)

@Suppress("UnusedPrivateProperty")
class Builder(
    name: String,
    experience: Int,
    prevExperience: Map<String, Int>,
    specialization: String
) : Employee(name, experience, prevExperience)
