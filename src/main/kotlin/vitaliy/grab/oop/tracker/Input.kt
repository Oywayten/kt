package vitaliy.grab.oop.tracker

interface Input {
    fun askStr(question: String?): String?

    fun askInt(question: String?): Int
}
