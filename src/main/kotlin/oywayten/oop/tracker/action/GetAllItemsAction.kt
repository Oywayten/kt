package oywayten.oop.tracker.action

import oywayten.oop.tracker.Input
import oywayten.oop.tracker.Item
import oywayten.oop.tracker.Output
import oywayten.oop.tracker.Store

class GetAllItemsAction(val output: Output) : MenuAction {

    val description = "Get all items"

    override fun description(): String {
        return description
    }

    override fun execute(input: Input, tracker: Store<Item>): Boolean {
        output.println("=== Show all items ===")
        val items = tracker.findAll()
        if (items.isNotEmpty()) {
            for (item in items) {
                output.println(item)
            }
        } else {
            output.println("Хранилище еще не содержит заявок")
        }
        return true
    }
}
