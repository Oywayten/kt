package vitaliy.grab.oop

import java.util.*

class MemTracker : Store {

    private val items = hashMapOf<UUID, Item>()

    override fun add(item: Item): Item {
        require(items[item.id] == null) { "Item with id ${item.id} already exists" }
        items[item.id] = item
        return item
    }

    override fun update(item: Item): Boolean {
        val currentItem = items[item.id]

        if (currentItem !is Item) {
            return false
        }

        items[item.id] = item
        return true
    }


    override fun delete(item: Item): Boolean =
        items.remove(item.id, item)


    override fun findAll(): List<Item> {
        return items.values.toList()
    }

    override fun findByName(name: String): List<Item> {
        val list = arrayListOf<Item>()

        for ((_, item) in items) {
            if (item.name == name) {
                list.add(item)
            }
        }

        return list
    }

    override fun findById(id: UUID): Item? {
        return items[id]
    }
}
