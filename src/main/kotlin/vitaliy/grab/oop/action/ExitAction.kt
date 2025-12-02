package vitaliy.grab.oop.action

import vitaliy.grab.oop.Input
import vitaliy.grab.oop.Output
import vitaliy.grab.oop.Store

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
