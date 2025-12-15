package vitaliy.grab.oop.tracker.action

import vitaliy.grab.oop.tracker.Input
import vitaliy.grab.oop.tracker.Item
import vitaliy.grab.oop.tracker.Output
import vitaliy.grab.oop.tracker.Store
import java.time.OffsetDateTime


class AddItemAction(val output: Output) : MenuAction {

    val description = "Add item"

    override fun description(): String {
        return description
    }

    override fun execute(input: Input, tracker: Store): Boolean {
        output.println("=== Create a new Item ====")
        val name = input.askStr("Enter name: ")
        val item = Item(name = name ?: "", created = OffsetDateTime.now())
        tracker.add(item)
        return true
    }
}
