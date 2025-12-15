package vitaliy.grab.oop.tracker.action

import vitaliy.grab.oop.tracker.Input
import vitaliy.grab.oop.tracker.Store

interface MenuAction {
    fun description(): String
    fun execute(input: Input, tracker: Store): Boolean
}
