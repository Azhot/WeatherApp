package fr.azhot.weatherapp.presentation.ui.city_list

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import fr.azhot.weatherapp.databinding.FragmentCityListBinding
import fr.azhot.weatherapp.domain.model.City
import fr.azhot.weatherapp.domain.type.UnitsType
import fr.azhot.weatherapp.presentation.BaseFragment
import fr.azhot.weatherapp.presentation.MainViewModel
import fr.azhot.weatherapp.presentation.ui.DataStateListener
import fr.azhot.weatherapp.presentation.ui.city_list.state.CityListStateEvent

@AndroidEntryPoint
class CityListFragment :
    BaseFragment<FragmentCityListBinding>({ (FragmentCityListBinding.inflate(it)) }) {

    private val viewModel: CityListViewModel by viewModels()
    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var dataStateListener: DataStateListener
    private lateinit var cityListAdapter: CityListAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            dataStateListener = context as DataStateListener
        } catch (e: ClassCastException) {
            Log.e(
                FragmentCityListBinding::class.simpleName,
                "$context must implement DataStateListener."
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        subscribeObservers()
    }

    private fun initRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            cityListAdapter = CityListAdapter()
            adapter = cityListAdapter
        }
    }

    private fun subscribeObservers() {
        mainViewModel.cities.observe(viewLifecycleOwner) {
            cityListAdapter.submitList(ArrayList<City>(it))
        }

        viewModel.dataState.observe(viewLifecycleOwner) { dataState ->

            // handle loading and message
            dataStateListener.onDataStateChange(dataState)

            // handle data
            dataState.data?.let { event ->
                event.getContentIfNotHandled()?.let { cityListViewState ->
                    cityListViewState.forecast?.let { forecast ->
                        viewModel.setForecastData(forecast)
                    }
                }
            }
        }

        viewModel.viewState.observe(viewLifecycleOwner) { viewState ->
            viewState.forecast?.let {
                println("DEBUG: setting forecast to RecyclerView")
                // update recyclerview
            }
        }
    }

//    private fun observeCurrentWeatherLiveData(liveData: LiveData<City>) {
//        liveData.observe(viewLifecycleOwner) {
//            binding.cityWeatherTextView.text = StringBuilder().run {
//                appendLine("City: ${it.city}") // to be removed
//                appendLine("Temperature: ${it.forecast.current.temp.toInt()}°C") // to be removed
//                appendLine("Weather condition: ${it.forecast.current.weather[0].main}") // to be removed
//                appendLine("Weather description: ${it.forecast.current.weather[0].description}") // to be removed
//                appendLine("Cloudiness: ${it.forecast.current.clouds}%") // to be removed
//                // todo: write a wind compass
//                appendLine("Wind direction: ${it.forecast.current.windDeg}°") // to be removed
//                appendLine("Wind speed: ${it.forecast.current.windSpeed} km/h") // to be removed
//                toString()
//            }
//        }
//    }

    private fun triggerGetForecastEvent(lat: Double, lon: Double, unitsType: UnitsType) {
        viewModel.setStateEvent(CityListStateEvent.GetForecastEvent(lat, lon, unitsType))
    }
}