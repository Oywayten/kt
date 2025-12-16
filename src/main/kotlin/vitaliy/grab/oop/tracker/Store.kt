package vitaliy.grab.oop.tracker

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
interface Store {
    fun add(item: Item): Item
    fun update(item: Item): Boolean
    fun delete(item: Item): Boolean
    fun findAll(): List<Item>
    fun findByName(name: String): List<Item>
    fun findById(id: Uuid?): Item?
}
