package fr.azhot.weatherapp.presentation.ui.city_list

import android.content.Context
import android.location.Address
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import fr.azhot.weatherapp.R

class AddressAutoCompleteAdapter(
        context: Context,
        private val addresses: List<Address>
) : ArrayAdapter<Address>(context, R.layout.cell_address_autocomplete_adapter, addresses) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = (convertView
                ?: View.inflate(context, R.layout.cell_address_autocomplete_adapter, null)
                ) as TextView
        val address = addresses[position]
        view.text = context.getString(R.string.address_name, address.locality, address.countryName)
        return view
    }
}