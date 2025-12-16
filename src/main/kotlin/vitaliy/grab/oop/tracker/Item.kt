package vitaliy.grab.oop.tracker

import java.time.OffsetDateTime
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
data class Item(
    var id: Uuid? = null,
    val name: String,
    val created: OffsetDateTime
)
