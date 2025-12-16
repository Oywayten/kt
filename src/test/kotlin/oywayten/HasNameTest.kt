package oywayten

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HasNameTest {

    @ParameterizedTest
    @MethodSource("hasNameDataProvider")
    fun whenHasName(srcList: List<Account>, rslList: List<Account>, expected: Boolean) {
        assertThat(srcList.filter(predicate) == rslList).isEqualTo(expected)
    }

    fun hasNameDataProvider(): List<Arguments> {
        val emptyList = emptyList<Account>()
        return listOf(
            arguments(listOf(Account("John", 1000)), emptyList, true),
            arguments(listOf(Account("John", 1000), Account("Bob", 3)), emptyList, true),
            arguments(emptyList, emptyList, true),
            arguments(listOf(Account("John", 1000), Account("Ivan", -1)), emptyList, true),

            arguments(
                listOf(
                    Account("John", 1000),
                    Account("Ivan", -100),
                    Account("Ivan", 100),
                    Account("Ivan", 100),
                    Account("Ivan", 100)
                ),
                listOf(
                    Account("Ivan", 100),
                    Account("Ivan", 100),
                    Account("Ivan", 100)
                ),
                true
            ),

            arguments(
                listOf(Account("John", 1000), Account("Ivan", -1)),
                listOf(Account("John", 1000)),
                false
            ),
            arguments(
                listOf(
                    Account("John", 1000),
                    Account("Ivan", -100),
                    Account("Ivan", 100),
                    Account("Ivan", 100),
                    Account("Ivan", 100)
                ),
                emptyList,
                false
            )
        )
    }
}
