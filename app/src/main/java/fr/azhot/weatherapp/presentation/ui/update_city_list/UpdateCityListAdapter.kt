package fr.azhot.weatherapp.presentation.ui.update_city_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import fr.azhot.weatherapp.R
import fr.azhot.weatherapp.databinding.CellUpdateCityListBinding
import fr.azhot.weatherapp.domain.model.City

class UpdateCityListAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<City>() {

        override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
            return oldItem.toString() == newItem.toString()
        }

    }
    private val differ = AsyncListDiffer(this, differCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CityViewHolder(
            CellUpdateCityListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            interaction
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CityViewHolder -> {
                holder.bind(differ.currentList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<City>) {
        differ.submitList(list)
    }

    inner class CityViewHolder(
        private val binding: CellUpdateCityListBinding,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(city: City) {
            binding.deleteImageButton.setOnClickListener {
                interaction?.onCityDeleted(city)
            }

            binding.textView.text =
                itemView.context.getString(R.string.city_name, city.name, city.country)
        }
    }

    interface Interaction {
        fun onCityDeleted(city: City)
    }
}