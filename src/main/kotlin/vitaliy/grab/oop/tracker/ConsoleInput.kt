package vitaliy.grab.oop.tracker

import java.util.Scanner

class ConsoleInput : Input {
    private val scanner = Scanner(System.`in`)

    override fun askStr(question: String?): String {
        print(question)
        return scanner.nextLine()
    }

    override fun askInt(question: String?): Int {
        return askStr(question).toInt()
    }
}
