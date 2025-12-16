package oywayten.oop

fun <T> emptySimpleLinkedList(): SimpleLinkedList<T> = SimpleLinkedList()

fun <T> simpleLinkedListOf(vararg elements: T): SimpleLinkedList<T> =
    if (elements.isNotEmpty()) elements.asSimpleLinkedList() else emptySimpleLinkedList()

private fun <T> Array<out T>.asSimpleLinkedList(): SimpleLinkedList<T> {
    val list = emptySimpleLinkedList<T>()
    for (t in this) {
        list.add(t)
    }
    listOf(1, 2)
    return list
}

class SimpleLinkedList<T> : Iterable<T> {

    private var modCount: Int = 0
    private var head: Node<T>? = null
    private var size: Int = 0

    // Comparison and hashing
    override fun equals(other: Any?): Boolean {
        if (other === this) return true
        if (other !is SimpleLinkedList<*>) return false

        val t1: Iterator<T?> = iterator()
        val t2: Iterator<*> = other.iterator()
        while (t1.hasNext() && t2.hasNext()) {
            val o1: T? = t1.next()
            val o2: Any? = t2.next()
            if (!(if (o1 == null) o2 == null else (o1 == o2))) return false
        }
        return !(t1.hasNext() || t2.hasNext())
    }

    override fun hashCode(): Int {
        var hashCode = 1
        for (e in this) hashCode = 31 * hashCode + (if (e == null) 0 else e.hashCode())
        return hashCode
    }

    fun size(): Int = size

    fun add(value: T) {
        if (head == null) {
            head = Node(value)
        } else {
            head!!.next = Node(value)
        }
        size++
        modCount++
    }

    override fun iterator(): Iterator<T> {
        return LinkedIt()
    }

    private inner class LinkedIt : Iterator<T> {
        private val modCountSnapshot = modCount
        var curr = head

        override fun hasNext(): Boolean {
            checkForComodification()
            return curr != null
        }

        private fun checkForComodification() {
            if (modCount != modCountSnapshot) throw ConcurrentModificationException()
        }

        override fun next(): T {
            if (!hasNext()) {
                throw NoSuchElementException()
            }
            val result = curr
            curr = curr!!.next
            return result!!.value
        }

    }

    private inner class Node<K>(val value: K, var next: Node<K>? = null)
}
