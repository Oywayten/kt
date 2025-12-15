package vitaliy.grab.oop.tracker.action

import vitaliy.grab.oop.tracker.Input
import vitaliy.grab.oop.tracker.Output
import vitaliy.grab.oop.tracker.Store

class GetAllItemsAction(val output: Output) : MenuAction {

    val description = "Get all items"

    override fun description(): String {
        return description
    }

    override fun execute(input: Input, tracker: Store): Boolean {
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
