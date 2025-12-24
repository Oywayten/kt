package oywayten.oop.tracker

import kotlin.uuid.ExperimentalUuidApi

@OptIn(ExperimentalUuidApi::class)
interface Store<T> {
    fun add(item: T): T
    fun update(item: T): Boolean
    fun delete(item: T): Boolean
    fun findAll(): List<T>
    fun findByName(name: String): List<T>
    fun findById(id: String): T?
}
