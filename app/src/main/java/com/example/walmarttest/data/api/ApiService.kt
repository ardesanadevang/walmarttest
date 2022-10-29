package com.example.walmarttest.data.api

import com.example.walmarttest.data.model.CountryItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json")
    suspend fun getCountries(): Response<List<CountryItem>>

    companion object {
        const val BASE_URL = "https://gist.githubusercontent.com/"
    }
}