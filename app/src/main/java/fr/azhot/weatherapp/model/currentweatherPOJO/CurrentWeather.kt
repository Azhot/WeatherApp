package fr.azhot.weatherapp.model.currentweatherPOJO

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CurrentWeather(
        @SerializedName("coord")
        @Expose
        var coordinates: Coordinates = Coordinates(),
        @SerializedName("weather")
        @Expose
        var weather: List<Weather> = listOf(),
        @SerializedName("main")
        @Expose
        var atmosphericData: AtmosphericData = AtmosphericData(),
        @SerializedName("visibility")
        @Expose
        // in meter
        var visibility: Int = 0,
        @SerializedName("wind")
        @Expose
        var wind: Wind = Wind(),
        @SerializedName("clouds")
        @Expose
        var clouds: Clouds = Clouds(),
        @SerializedName("dt")
        @Expose
        // Time of data calculation, unix, UTC
        var dt: Int = 0,
        @SerializedName("sys")
        @Expose
        var location: Location = Location(),
        @SerializedName("timezone")
        @Expose
        // Shift in seconds from UTC
        var timezone: Int = 0,
        @SerializedName("id")
        @Expose
        var cityId: Int = 0,
        @SerializedName("name")
        @Expose
        var cityName: String = "",
)