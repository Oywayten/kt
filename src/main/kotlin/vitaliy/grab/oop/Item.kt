package vitaliy.grab.oop

import java.time.OffsetDateTime
import java.util.UUID

data class Item(
    var id: UUID = UUID.randomUUID(),
    var name: String,
    var created: OffsetDateTime = OffsetDateTime.now(),
)
