package vitaliy.grab.oop

import java.time.OffsetDateTime

data class Item(
    var id: Int = -1,
    var name: String,
    val created: OffsetDateTime = OffsetDateTime.now(),
    val participates: MutableList<String> = mutableListOf()
)
