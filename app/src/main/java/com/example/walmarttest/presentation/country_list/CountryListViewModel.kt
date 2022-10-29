package com.example.walmarttest.presentation.country_list

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.walmarttest.domain.model.Country
import com.example.walmarttest.domain.usecase.CountryUsecase
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class CountryListViewModel @Inject constructor(
    private val countryUsecase: CountryUsecase
): ViewModel() {

    fun onEvent(event: CountryListEvent) {
        when(event) {
            is CountryListEvent.GetCountryList -> {
                runBlocking {
                    launch {
                        val countries = countryUsecase.getCountries.invoke()
                        Log.d("api response", Gson().toJson(countries))
                    }
                }
            }
        }
    }
}