package vitaliy.grab.oop

object MemStore {
    private val data = arrayListOf<String>()

    fun add(value: String) {
        data.add(value)
    }

    fun getAll() =
        data
}
