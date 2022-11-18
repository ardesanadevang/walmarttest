package com.example.walmarttest.domain.usecase

import android.app.Application
import com.example.walmarttest.R
import com.example.walmarttest.data.model.CountryItem
import com.example.walmarttest.domain.dto.Country
import com.example.walmarttest.domain.repository.CountryRespository
import com.example.walmarttest.domain.util.exception.ApiException
import okhttp3.ResponseBody
import retrofit2.Response

class GetCountries(
    val countryRespository: CountryRespository,
    val application: Application
) {
    @Throws(ApiException::class)
    suspend operator fun invoke(): List<Country> {
        val response:Response<List<CountryItem>> = countryRespository.getCountries()
        if(response.isSuccessful)
            return response.body()?.map { it.toCountryModel() } ?: emptyList()
        else {
            val body:ResponseBody? = response.errorBody()
            throw ApiException(body?.string() ?: application.getString(R.string.no_internet_message))
        }
    }
}