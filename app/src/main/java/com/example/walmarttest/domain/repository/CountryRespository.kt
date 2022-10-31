package com.example.walmarttest.domain.repository

import com.example.walmarttest.data.model.CountryItem
import retrofit2.Response

interface CountryRespository {
    suspend fun getCountries(): Response<List<CountryItem>>
}