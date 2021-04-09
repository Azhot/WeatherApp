package fr.azhot.weatherapp.presentation

import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import fr.azhot.weatherapp.R
import fr.azhot.weatherapp.databinding.ActivityMainBinding
import fr.azhot.weatherapp.presentation.ui.DataStateListener
import fr.azhot.weatherapp.util.DataState


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it) }),
    DataStateListener {

    private val navHostFragment by lazy {
        supportFragmentManager.findFragmentById(binding.mainContainerView.id) as NavHostFragment
    }
    private val navController by lazy { navHostFragment.findNavController() }

    // overridden functions
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.let {
            menuInflater.inflate(R.menu.menu, it)
            return true
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.searchMenuItem -> {
                navController.navigate(R.id.action_cityListFragment_to_updateCityListFragment)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDataStateChange(dataState: DataState<*>?) {
        handleDataStateChange(dataState)
    }


    // functions
    private fun handleDataStateChange(dataState: DataState<*>?) {
        dataState?.let {
            // handle error
            dataState.message?.let { event ->
                event.getContentIfNotHandled()?.let { message ->
                    showToast(message)
                }
            }

            // handle loading
            showProgressBar(it.loading)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun showProgressBar(isVisible: Boolean) {
        binding.progressBar.visibility = if (isVisible) View.VISIBLE else View.GONE
    }
}