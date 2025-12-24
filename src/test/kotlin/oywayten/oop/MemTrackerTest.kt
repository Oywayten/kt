package oywayten.oop

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.SoftAssertions
import oywayten.oop.tracker.Item
import oywayten.oop.tracker.MemTracker
import oywayten.oop.tracker.Store
import java.time.OffsetDateTime
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
class MemTrackerTest {

    lateinit var tracker: Store<Item>

    @BeforeTest
    fun setUp() {
        tracker = MemTracker()
    }

    @Test
    fun whenAddNewItemThenTrackerHasSameItem() {
        val item = Item(Uuid.random().toString(), "Test1", OffsetDateTime.now())
        val added = tracker.add(item)

        SoftAssertions.assertSoftly {
            it.assertThat(added).isNotNull()
            it.assertThat(added).isEqualTo(item)
        }
    }

    @Test
    fun whenAddAndIdAlreadyExistsThenIllegalArgumentException() {
        val id = Uuid.random().toString()
        val item = Item(id, "Test1", OffsetDateTime.now())
        tracker.add(item)

        assertThatThrownBy { tracker.add(item) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .withFailMessage("Item with id $id already exists")
    }

    @Test
    fun whenTestFindById() {
        val bug = Item(Uuid.random().toString(), "Bug", OffsetDateTime.now())
        val added = tracker.add(bug)

        val result = tracker.findById(added.id)
        SoftAssertions.assertSoftly {
            it.assertThat(bug).isEqualTo(added)
            it.assertThat(result).isEqualTo(added)
        }
    }

    @Test
    fun whenTestFindAll() {
        val first = Item(Uuid.random().toString(), "First", OffsetDateTime.now())
        val second = Item(Uuid.random().toString(), "Second", OffsetDateTime.now())
        tracker.add(first)
        tracker.add(second)

        val items: List<Item> = tracker.findAll()
        SoftAssertions.assertSoftly {
            it.assertThat(items.size).isEqualTo(2)
            it.assertThat(items).containsExactlyInAnyOrder(first, second)
        }
    }

    @Test
    fun whenTestFindByNameCheckSecondItemName() {
        val first = Item(Uuid.random().toString(), "First", OffsetDateTime.now())
        val second = Item(Uuid.random().toString(), "Second", OffsetDateTime.now())
        tracker.add(first)
        tracker.add(second)
        tracker.add(Item(Uuid.random().toString(), "First", OffsetDateTime.now()))
        tracker.add(Item(Uuid.random().toString(), "Second", OffsetDateTime.now()))
        tracker.add(Item(Uuid.random().toString(), "First", OffsetDateTime.now()))

        val result: List<Item> = tracker.findByName(second.name)
        SoftAssertions.assertSoftly {
            it.assertThat(result.size).isEqualTo(2)
            it.assertThat(result[1].name).isEqualTo(second.name)
        }
    }

    @Test
    fun whenReplace() {
        val bug = Item(Uuid.random().toString(), "Bug", OffsetDateTime.now())
        tracker.add(bug)
        val id = bug.id
        val bugWithDesc = Item(id, "Bug with description", OffsetDateTime.now())
        val update = tracker.update(bugWithDesc)
        val item: Item? = tracker.findById(id)

        SoftAssertions.assertSoftly {
            it.assertThat(update).isTrue
            it.assertThat(item?.name).isEqualTo("Bug with description")
        }
    }

    @Test
    fun whenDelete() {
        val bug = Item(Uuid.random().toString(), "Bug", OffsetDateTime.now())
        tracker.add(bug)

        val delete = tracker.delete(bug)
        SoftAssertions.assertSoftly {
            it.assertThat(delete).isTrue
            it.assertThat(tracker.findById(bug.id)).isNull()
        }
    }
}
