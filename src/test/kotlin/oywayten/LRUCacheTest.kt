package oywayten

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LRUCacheTest {

    @Test
    fun `put and get simple`() {
        val cache = LRUCache<Int, String>(2)
        cache[1] = "one"
        cache[2] = "two"

        assertThat("one").isEqualTo(cache[1])
        assertThat("two").isEqualTo(cache[2])
        assertThat(cache[3]).isNull()
        assertThat(2).isEqualTo(cache.size)
    }

    @Test
    fun `evict least recently used on overflow`() {
        val cache = LRUCache<Int, String>(2)
        cache[1] = "one"
        cache[2] = "two"
        cache[1]
        cache[3] = "three"

        assertThat(cache[2]).isNull()
        assertThat("one").isEqualTo(cache[1])
        assertThat("three").isEqualTo(cache[3])
        assertThat(2).isEqualTo(cache.size)
    }

    @Test
    fun `recently used updates order`() {
        val cache = LRUCache<Int, String>(3)
        cache[1] = "a"
        cache[2] = "b"
        cache[3] = "c"

        cache[2]

        cache[4] = "d"

        assertThat(cache[1]).isNull()
        assertThat("b").isEqualTo(cache[2])
        assertThat("c").isEqualTo(cache[3])
        assertThat("d").isEqualTo(cache[4])
    }

    @Test
    fun `capacity must be positive`() {
        assertThrows<IllegalArgumentException> {
            LRUCache<Int, String>(-5)
        }
    }
}
