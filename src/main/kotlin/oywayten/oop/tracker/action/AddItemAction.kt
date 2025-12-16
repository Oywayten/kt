package oywayten.oop.tracker.action

import oywayten.oop.tracker.Input
import oywayten.oop.tracker.Item
import oywayten.oop.tracker.Output
import oywayten.oop.tracker.Store
import java.time.OffsetDateTime
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
class AddItemAction(val output: Output) : MenuAction {

    val description = "Add item"

    override fun description(): String {
        return description
    }

    override fun execute(input: Input, tracker: Store): Boolean {
        output.println("=== Create a new Item ====")
        val name = input.askStr("Enter name: ")
        val item = Item(Uuid.random(), name ?: "", OffsetDateTime.now())
        tracker.add(item)
        return true
    }
}
