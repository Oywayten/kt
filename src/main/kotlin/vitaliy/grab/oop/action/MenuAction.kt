package vitaliy.grab.oop.action

import vitaliy.grab.oop.Input
import vitaliy.grab.oop.Store

interface MenuAction {
    fun description(): String
    fun execute(input: Input, tracker: Store): Boolean
}
