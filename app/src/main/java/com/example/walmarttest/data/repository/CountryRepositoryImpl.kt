package com.example.walmarttest.data.repository

import com.example.walmarttest.data.api.ApiService
import com.example.walmarttest.data.model.CountryItem
import com.example.walmarttest.domain.model.Country
import com.example.walmarttest.domain.repository.CountryRespository
import retrofit2.Response

class CountryRepositoryImpl(
    private val apiService: ApiService
): CountryRespository {
    override suspend fun getCountries(): Response<List<CountryItem>> {
        // handle all errors
        return apiService.getCountries()
    }
}