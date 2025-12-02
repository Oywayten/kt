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
        val added = tracker.add(item)

        SoftAssertions.assertSoftly {
            assertThat(added).isNotNull()
            assertThat(added).isEqualTo(item)
        }

    }

    @Test
    fun whenTestFindById() {
        val bug = Item(name = "Bug")
        val added = tracker.add(bug)

        val result = tracker.findById(added.id)
        SoftAssertions.assertSoftly {
            assertThat(bug).isEqualTo(added)
            assertThat(result).isEqualTo(added)
        }
    }

    @Test
    fun whenTestFindAll() {
        val first = Item(name = "First")
        val second = Item(name = "Second")
        tracker.add(first)
        tracker.add(second)

        val items: List<Item> = tracker.findAll()
        SoftAssertions.assertSoftly {
            assertThat(items.size).isEqualTo(2)
            assertThat(items).containsExactlyInAnyOrder(first, second)
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
    }

    @Test
    fun whenReplace() {
        val bug = Item(name = "Bug")
        tracker.add(bug)
        val id = bug.id
        val bugWithDesc = Item(id, "Bug with description")
        val update = tracker.update(bugWithDesc)
        val item: Item? = tracker.findById(id)

        SoftAssertions.assertSoftly {
            assertThat(update).isTrue
            assertThat(item?.name).isEqualTo("Bug with description")
        }
    }

    @Test
    fun whenDelete() {
        val bug = Item(name = "Bug")
        tracker.add(bug)

        val delete = tracker.delete(bug)
        SoftAssertions.assertSoftly {
            assertThat(delete).isTrue
            assertThat(tracker.findById(bug.id)).isNull()
        }
    }
}
