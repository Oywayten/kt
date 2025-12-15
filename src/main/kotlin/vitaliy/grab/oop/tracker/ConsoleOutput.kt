package vitaliy.grab.oop.tracker

class ConsoleOutput : Output {
    override fun println(obj: Any?) {
        kotlin.io.println(obj)
    }
}
