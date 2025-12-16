package oywayten.oop.tracker

import oywayten.oop.tracker.action.AddItemAction
import oywayten.oop.tracker.action.ExitAction
import oywayten.oop.tracker.action.GetAllItemsAction
import oywayten.oop.tracker.action.MenuAction

fun init(output: Output, input: Input, tracker: Store, actions: List<MenuAction>) {
    var run = true
    while (run) {
        MenuDemonstrator.showMenu(actions)
        val select = input.askInt("Select: ")
        if (select < 0 || select >= actions.size) {
            output.println("Wrong input, you can select: 0 .. " + (actions.size - 1))
            continue
        }

        val action = actions.get(select)
        run = action.execute(input, tracker)
    }
}


fun main() {
    val output = ConsoleOutput()
    val input = ValidateInput(output, ConsoleInput())
    val tracker = MemTracker()
    val actions = listOf(
        AddItemAction(output),
        GetAllItemsAction(output),
        ExitAction(output)
    )

    init(output, input, tracker, actions)

}

class MenuDemonstrator private constructor() {
    companion object {
        fun showMenu(actions: List<MenuAction>) {
            println("Menu")
            for ((i, action) in actions.withIndex()) {
                println("$i. ${action.description()}")
            }
        }
    }
}
