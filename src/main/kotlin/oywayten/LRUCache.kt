package oywayten

private const val LOAD_FACTOR = 0.75f

class LRUCache<K, V>(val maxSize: Int) : LinkedHashMap<K, V>(maxSize, LOAD_FACTOR, true) {
    companion object {
        @Suppress("unused")
        private const val serialVersionUID: Long = 8814277255267378442L
    }

    override fun removeEldestEntry(eldest: Map.Entry<K, V>): Boolean {
        return size > maxSize
    }
}
