package vitaliy.grab.oop

import java.util.Scanner

private const val NOT_IMPLEMENTED = "Not implemented"

private const val INPUT_YOU_COMMAND_NUMBER_ = "Input you command number: "

private const val EXIT = "EXIT"

private const val INPUT_ITEM_NAME_ = "Input item name: "

private const val GREETENG = """
            Hello, select next command:
                1 - add item
                2 - show all items
                3 - exit  
            """

private const val EXIT_COMMAND = 3

object StartUi {
    
    private val sc: Scanner = Scanner(System.`in`)

    fun init() {
        var command = 0
        while (command != EXIT_COMMAND) {
            when (command) {
                0 -> greeting()
                1 -> addItem()
                2 -> getAllItems()
                else -> println(NOT_IMPLEMENTED)
            }

            print(INPUT_YOU_COMMAND_NUMBER_)
            command = sc.nextInt()
        }

        sc.close()
        println(EXIT)
    }

    private fun getAllItems() =
        println(MemStore.getAll())


    private fun addItem() {
        print(INPUT_ITEM_NAME_)
        val item: String = sc.next()
        MemStore.add(item)
    }

    private fun greeting() =
        println(GREETENG.trimIndent())

}
