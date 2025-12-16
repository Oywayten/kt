package oywayten.oop.tracker.action

import oywayten.oop.tracker.Input
import oywayten.oop.tracker.Store

interface MenuAction {
    fun description(): String
    fun execute(input: Input, tracker: Store): Boolean
}
