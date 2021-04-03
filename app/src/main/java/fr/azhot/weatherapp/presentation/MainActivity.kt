package fr.azhot.weatherapp.presentation

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import fr.azhot.weatherapp.R
import fr.azhot.weatherapp.databinding.ActivityMainBinding
import fr.azhot.weatherapp.presentation.ui.city_list.CityListViewModel


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // variables
    private lateinit var binding: ActivityMainBinding


    // overridden functions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
    }

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
                // code here starting new screen
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


    // functions
    private fun initViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}