package vitaliy.grab.oop

import java.util.*

class MemTracker : Store {

    val items = hashMapOf<UUID, Item>()

    override fun add(item: Item): Item {
        items[item.id] = item
        val added = items[item.id]
        require(added != null)
        return added
    }

    override fun update(item: Item): Boolean {
        val currentItem = items[item.id]

        if (currentItem !is Item) {
            return false
        }

        if (currentItem.name != item.name) {
            currentItem.name = item.name
        }

        if (currentItem.created.equals(item.created)) {
            currentItem.created = item.created
        }

        return true
    }


    override fun delete(item: Item): Boolean =
        items.remove(item.id, item)


    override fun findAll(): List<Item> {
        return items.values.toList()
    }

    override fun findByName(name: String): List<Item> {
        val list = arrayListOf<Item>()

        for ((_, item ) in items) {
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
