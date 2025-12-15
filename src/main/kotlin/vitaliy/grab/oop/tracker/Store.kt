package vitaliy.grab.oop.tracker

import java.util.UUID

interface Store {
    fun add(item: Item): Item
    fun update(item: Item): Boolean
    fun delete(item: Item): Boolean
    fun findAll(): List<Item>
    fun findByName(name: String): List<Item>
    fun findById(id: UUID): Item?
}
