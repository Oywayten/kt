package oywayten

class CitiesLoader {
    val cities: List<String> by lazy { loadCities() }

    private fun loadCities(): List<String> =
        listOf("Moscow", "St-Pete", "NY")
}
