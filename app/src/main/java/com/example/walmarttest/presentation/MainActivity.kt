package com.example.walmarttest.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.Visibility
import com.example.walmarttest.R
import com.example.walmarttest.databinding.ActivityMainBinding
import com.example.walmarttest.domain.util.Util
import com.example.walmarttest.presentation.country_list.CountryListEvent
import com.example.walmarttest.presentation.country_list.CountryListViewModel
import com.example.walmarttest.presentation.country_list.adapter.CountryListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var countryListViewModel: CountryListViewModel
    private lateinit var countryListAdapter: CountryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        countryListViewModel = ViewModelProvider(this).get(CountryListViewModel::class.java)



        binding.rcvCountryList.layoutManager = LinearLayoutManager(this)
        countryListAdapter = CountryListAdapter()
        binding.rcvCountryList.adapter = countryListAdapter

        countryListViewModel.countries.observe(this, Observer {
            countryListAdapter.setCountries(it)
            countryListAdapter.notifyDataSetChanged()
        })

        countryListViewModel.toastMessage.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })

        countryListViewModel.loaderVisibility.observe(this, Observer {
            if (it)
                binding.progressBar.visibility = View.VISIBLE
            else
                binding.progressBar.visibility = View.INVISIBLE
        })

        getCountries()
    }

    private fun getCountries() {
        val time = measureTimeMillis {
            if (Util.isNetworkAvailable(this))
            countryListViewModel.getCountries()
            else
                countryListViewModel.toastMessage.value = getString(R.string.no_internet_message)
        }
        Log.d("Total Time api : ", ""+time)
    }

}