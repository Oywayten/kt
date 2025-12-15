package vitaliy.grab.oop.tracker.action

import vitaliy.grab.oop.tracker.Input
import vitaliy.grab.oop.tracker.Output
import vitaliy.grab.oop.tracker.Store

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
