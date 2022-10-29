package com.example.walmarttest.presentation

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.walmarttest.R
import com.example.walmarttest.databinding.ActivityMainBinding
import com.example.walmarttest.domain.model.Country
import com.example.walmarttest.presentation.country_list.CountryListEvent
import com.example.walmarttest.presentation.country_list.CountryListViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var countryListViewModel: CountryListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        countryListViewModel = ViewModelProvider(this).get(CountryListViewModel::class.java)

        countryListViewModel.onEvent(CountryListEvent.GetCountryList)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

}