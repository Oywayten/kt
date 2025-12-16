package oywayten.oop.tracker

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
class MemTracker : Store {

    private val items = hashMapOf<Uuid?, Item>()

    override fun add(item: Item): Item {
        require(item.id !in items) {
            "Item with id ${item.id} already exists"
        }

        items[item.id] = item
        return item
    }

    override fun update(item: Item): Boolean {
        if (item.id !in items) {
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

    @OptIn(ExperimentalUuidApi::class)
    override fun findByName(name: String): List<Item> {
        return items.values
            .filter { name == it.name }
    }

    override fun findById(id: Uuid?): Item? {
        return items[id]
    }
}
