package vitaliy.grab.oop.tracker

import java.time.OffsetDateTime
import java.util.UUID

data class Item(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val created: OffsetDateTime
)
