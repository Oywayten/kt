package oywayten

import org.assertj.core.api.SoftAssertions
import kotlin.test.Test

class CitiesLoaderTest {

    @Test
    fun whenGetCitiesThenInitialized() {
        val citiesLoader = CitiesLoader()
        val cities = citiesLoader.cities
        SoftAssertions.assertSoftly {
            val assert = it.assertThatList(cities)
            with(assert) {
                isNotNull
                hasSize(3)
                isEqualTo(listOf("Moscow", "St-Pete", "NY"))
            }
        }
    }

}
