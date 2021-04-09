//package fr.azhot.weatherapp.viewModelTest
//
//import android.location.Address
//import androidx.test.ext.junit.runners.AndroidJUnit4
//import fr.azhot.weatherapp.domain.type.UnitsType
//import fr.azhot.weatherapp.presentation.ui.city_list.CityListViewModel
//import fr.azhot.weatherapp.viewModelTest.testHelper.getOrAwaitValue
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import org.junit.Assert.assertEquals
//import org.junit.Test
//import org.junit.runner.RunWith
//import java.util.*
//import javax.inject.Inject
//
//@RunWith(AndroidJUnit4::class)
//class CityListViewModelTest {
//
//    @Inject
//    private lateinit var viewModel: CityListViewModel
//
//    @Test
//    fun shouldReturnFranceIfFetchWeatherWithAddressInFrance() {
//        CoroutineScope(Dispatchers.Main).launch {
//            runCatching {
//                viewModel.fetchForecast(Address(Locale.FRANCE), UnitsType.metric)
//                assertEquals(
//                    "France",
//                    viewModel.cityLiveData.getOrAwaitValue().country
//                )
//            }.run {
//                this.exceptionOrNull()?.let { throwable ->
//                    println(throwable.message)
//                }
//            }
//        }
//    }
//
//    @Test
//    fun shouldReturnParisIfFetchAutocompleteWithParis() {
//        CoroutineScope(Dispatchers.Main).launch {
//            runCatching {
//                viewModel.fetchAddresses("Paris")
//                assertEquals(
//                    "Paris",
//                    viewModel.addressesLiveData.getOrAwaitValue()[0].locality
//                )
//            }.run {
//                this.exceptionOrNull()?.let { throwable ->
//                    println(throwable.message)
//                }
//            }
//        }
//    }
//}