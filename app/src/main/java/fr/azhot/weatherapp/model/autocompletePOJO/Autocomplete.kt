package fr.azhot.weatherapp.model.autocompletePOJO

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Autocomplete {
        @SerializedName("items")
        @Expose
        var items: List<Item>? = null
}
