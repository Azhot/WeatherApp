package fr.azhot.weatherapp.domain.model

data class City(
    val name: String,
    val country: String,
    val forecast: Forecast? = null,
) {
    override fun toString(): String {
        return "City(name='$name', country='$country', forecast=$forecast)"
    }
}