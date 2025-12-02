package vitaliy.grab.oop

class ConsoleOutput : Output {
    override fun println(obj: Any?) {
        kotlin.io.println(obj)
    }
}
