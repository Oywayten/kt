package vitaliy.grab.oop

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.SoftAssertions
import kotlin.test.BeforeTest
import kotlin.test.Test

class MemTrackerTest {

    lateinit var tracker: Store

    @BeforeTest
    fun setUp() {
        tracker = MemTracker()
    }

    @Test
    fun whenAddNewItemThenTrackerHasSameItem() {
        val item = Item(name = "Test1")
        tracker.add(item)
        val result = tracker.findById(item.id)
        assertThat(result?.name).isEqualTo(item.name)
    }

    @Test
    fun whenTestFindById() {
        val bug = Item(name = "Bug")
        val item = tracker.add(bug)
        val result = tracker.findById(item.id)
        assertThat(result?.name).isEqualTo(item.name)
    }

    @Test
    fun whenTestFindAll() {
        val first = Item(name = "First")
        val second = Item(name = "Second")
        tracker.add(first)
        tracker.add(second)
        val items: List<Item> = tracker.findAll()
        val result = items.first()
        SoftAssertions.assertSoftly {
            assertThat(items.size).isEqualTo(2)
            assertThat(result.name).isEqualTo(first.name)
        }

    }

    @Test
    fun whenTestFindByNameCheckSecondItemName() {
        val first = Item(name = "First")
        val second = Item(name = "Second")
        tracker.add(first)
        tracker.add(second)
        tracker.add(Item(name = "First"))
        tracker.add(Item(name = "Second"))
        tracker.add(Item(name = "First"))
        val result: List<Item> = tracker.findByName(second.name)
        SoftAssertions.assertSoftly {
            assertThat(result.size).isEqualTo(2)
            assertThat(result[1].name).isEqualTo(second.name)
        }

        @Test
        fun whenReplace() {
            val bug = Item(name = "Bug")
            tracker.add(bug)
            val id = bug.id
            val bugWithDesc = Item(name = "Bug with description")
            tracker.replace(id, bugWithDesc)
            val item: Item? = tracker.findById(id)
            assertThat(item?.name).isEqualTo("Bug with description")
        }

        @Test
        fun whenDelete() {
            val bug = Item(name = "Bug")
            tracker.add(bug)
            val id = bug.id
            tracker.delete(id)
            assertThat(tracker.findById(id)).isNull()
        }
    }
}
