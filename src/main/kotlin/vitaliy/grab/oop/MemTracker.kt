package vitaliy.grab.oop

class MemTracker(var ids: Int = 1, val items: MutableList<Item> = mutableListOf()) : Store {
    override fun add(item: Item): Item {
        item.id = ids++
        items.add(item)
        return item
    }

    override fun replace(id: Int, item: Item): Boolean {
        return execIfPresent(id) { index: Int ->
            item.id = id
            items[index] = item
        }
    }

    fun execIfPresent(id: Int, exec: (Int) -> Unit): Boolean {
        val index: Int = items.indexOfFirst { it.id == id }
        return if (index == -1) {
            false
        } else {
            exec(index)
            true
        }
    }

    override fun delete(id: Int): Boolean {
        return execIfPresent(id) { index: Int ->
            items.removeAt(index)
            ids--
        }
    }

    override fun findAll(): List<Item> {
        return items.toList()
    }

    override fun findByName(name: String): List<Item> {
        return items.filter { it.name == name }
    }

    override fun findById(id: Int): Item? {
        return items.firstOrNull { it.id == id }
    }
}
