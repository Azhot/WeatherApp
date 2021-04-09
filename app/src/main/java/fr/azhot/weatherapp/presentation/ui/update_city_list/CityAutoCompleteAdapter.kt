package fr.azhot.weatherapp.presentation.ui.update_city_list

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import fr.azhot.weatherapp.R
import fr.azhot.weatherapp.domain.model.City

class CityAutoCompleteAdapter(
    context: Context,
    private val cities: List<City>
) : ArrayAdapter<City>(context, R.layout.cell_city_autocomplete, cities) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = (convertView
            ?: View.inflate(context, R.layout.cell_city_autocomplete, null)
                ) as TextView
        val city = cities[position]
        view.text = context.getString(R.string.city_name, city.name, city.country)
        return view
    }
}