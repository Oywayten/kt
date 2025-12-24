package oywayten.oop.tracker

import java.time.OffsetDateTime
import kotlin.uuid.ExperimentalUuidApi

@OptIn(ExperimentalUuidApi::class)
data class Item(
    val id: String,
    val name: String,
    val created: OffsetDateTime
) {
    fun Item.save() {
        MemTracker.tracker.add(this)
    }
}
