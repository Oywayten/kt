package oywayten.oop.tracker

class ConsoleOutput : Output {
    override fun println(obj: Any?) {
        kotlin.io.println(obj)
    }
}
