@file:Suppress("unused")

package oywayten.oop

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.Test

@Suppress("UnusedPrivateMember")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SimpleLinkedListTest {

    @ParameterizedTest
    @MethodSource("equalsTwoListsDataProvider")
    fun <T> equalsTwoListsSuccess(first: SimpleLinkedList<T>, second: SimpleLinkedList<T>, equalsExpected: Boolean) {
        assertThat(first.equals(second)).isEqualTo(equalsExpected)
    }

    private fun equalsTwoListsDataProvider(): List<Arguments> =
        listOfNotNull(
            arguments(simpleLinkedListOf(1, 2), simpleLinkedListOf(1, 2), true),
            arguments(simpleLinkedListOf(1, null), simpleLinkedListOf(1, null), true),
            arguments(simpleLinkedListOf(null, null), simpleLinkedListOf(null, null), true),
            arguments(simpleLinkedListOf("sgdsfgsdf", "2"), simpleLinkedListOf("sgdsfgsdf", "2"), true),
            arguments(emptySimpleLinkedList<Int>(), emptySimpleLinkedList<Int>(), true),

            arguments(simpleLinkedListOf(1, 2), simpleLinkedListOf(34, 2), false),
            arguments(simpleLinkedListOf(1, 2), simpleLinkedListOf(34), false),
            arguments(simpleLinkedListOf("", "dfdfd"), simpleLinkedListOf("1", 2), false),
            arguments(emptySimpleLinkedList<Int>(), simpleLinkedListOf(1, 2, 3), false),
            arguments(emptySimpleLinkedList<Int>(), simpleLinkedListOf(null, null), false)
        )

    @ParameterizedTest
    @MethodSource("equalsSizeDataProvider")
    fun <T> equalsSize(list: SimpleLinkedList<T>, size: Int, equalsExpected: Boolean) {
        assertThat(list.size() == size).isEqualTo(equalsExpected)
    }

    private fun equalsSizeDataProvider(): List<Arguments> =
        listOfNotNull(
            arguments(emptySimpleLinkedList<Int>(), 0, true),
            arguments(emptySimpleLinkedList<String>(), 0, true),
            arguments(simpleLinkedListOf(null), 1, true),
            arguments(simpleLinkedListOf(null, null), 2, true),
            arguments(simpleLinkedListOf(null, null, 999), 3, true),
            arguments(simpleLinkedListOf(1, null), 2, true),
            arguments(simpleLinkedListOf(1, 2, 3, 4, 5), 5, true),
            arguments(simpleLinkedListOf("df"), 1, true),
            arguments(simpleLinkedListOf("a", "b", "c"), 3, true),
            arguments(simpleLinkedListOf<Int>(), 0, true),

            arguments(emptySimpleLinkedList<Int>(), 1, false),
            arguments(emptySimpleLinkedList<String>(), -1, false),
            arguments(simpleLinkedListOf(null), 2, false),
            arguments(simpleLinkedListOf(null, null), 100, false),
            arguments(simpleLinkedListOf<Int>(), 4, false)
        )

    @Test
    fun whenEmptyThenHasNextFalseNextException() {
        val iterator = emptySimpleLinkedList<Any>().iterator()
        val actual = iterator.hasNext()

        assertThat(actual).isFalse
        assertThatThrownBy{iterator.next()}
            .isExactlyInstanceOf(NoSuchElementException::class.java)
    }

    @Test
    fun whenOneThenOneHasNextTrueNextGetElement() {
        val testElement = 1
        val iterator = simpleLinkedListOf(testElement).iterator()

        assertThat(iterator.hasNext()).isTrue
        assertThat(iterator.next()).isEqualTo(testElement)
        assertThat(iterator.hasNext()).isFalse
        assertThatThrownBy{iterator.next()}
            .isExactlyInstanceOf(NoSuchElementException::class.java)
    }

}
