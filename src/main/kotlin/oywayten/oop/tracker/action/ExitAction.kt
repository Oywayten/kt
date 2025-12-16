package oywayten.oop.tracker.action

import oywayten.oop.tracker.Input
import oywayten.oop.tracker.Output
import oywayten.oop.tracker.Store

class ExitAction(val output: Output) : MenuAction {

    private val description = "EXIT"

    override fun description(): String {
        return description
    }

    override fun execute(input: Input, tracker: Store): Boolean {
        output.println(description)
        return false
    }
}
