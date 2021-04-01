package fr.azhot.weatherapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.azhot.weatherapp.databinding.CellCityBinding

class CityAdatper(
    val cityNames: MutableList<String>
) : RecyclerView.Adapter<CityAdatper.CityViewHolder>() {


    // overridden functions
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = CellCityBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CityViewHolder(view)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val cityName = cityNames[position]
        holder.bind(cityName)
    }

    override fun getItemCount(): Int {
        return cityNames.count()
    }


    // view holder
    class CityViewHolder(
        private val binding: CellCityBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        internal fun bind(cityName: String) {
            binding.root.text = cityName
        }
    }
}