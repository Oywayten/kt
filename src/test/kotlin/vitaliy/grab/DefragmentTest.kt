package vitaliy.grab

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Suppress("unused")
class DefragmentTest {

    @ParameterizedTest
    @MethodSource("getArraysWithNulls")
    fun whenDefragmentFromStartToEndHasValidOrder(array: Array<String?>, expected: Array<String?>) {
        defragment(array)
        assertThat(array).isEqualTo(expected)
    }

    private fun getArraysWithNulls(): List<Arguments> {
        return listOf(
            Arguments.of(arrayOf("test1", null, "test2", null), arrayOf("test1", "test2", null, null)),
            Arguments.of(arrayOf("test1", null, null, "test2"), arrayOf("test1", "test2", null, null)),
            Arguments.of(arrayOf(null, null, "test1", "test2"), arrayOf("test1", "test2", null, null)),
            Arguments.of(arrayOf(null, null, "test1", null), arrayOf("test1", null, null, null)),
            Arguments.of(arrayOfNulls<String?>(4), arrayOfNulls<String?>(4)),
            Arguments.of(arrayOf("test1", "test2", "test3", "test4"), arrayOf("test1", "test2", "test3", "test4"))
        )
    }

}
