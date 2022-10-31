package com.example.walmarttest.presentation.country_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walmarttest.domain.dto.Country
import com.example.walmarttest.domain.usecase.CountryUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class CountryListViewModel @Inject constructor(
    private val countryUsecase: CountryUsecase
) : ViewModel() {

    var countries = MutableLiveData<List<Country>>()
    var toastMessage = MutableLiveData<String>()
    var loaderVisibility = MutableLiveData<Boolean>()

    fun getCountries() {
        viewModelScope.launch {
            try {
                loaderVisibility.value = true
                countries.value = countryUsecase.getCountries.invoke()
            } catch (e: Exception) {
                viewModelScope.launch {
                    toastMessage.value = e.message
                }
            }
            loaderVisibility.value = false
        }
    }
}