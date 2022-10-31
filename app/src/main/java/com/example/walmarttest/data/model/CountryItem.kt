package com.example.walmarttest.data.model


import com.example.walmarttest.domain.dto.Country
import com.google.gson.annotations.SerializedName

data class CountryItem(
    @SerializedName("capital")
    val capital: String,

    @SerializedName("code")
    val code: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("region")
    val region: String
) {
    fun toCountryModel(): Country {
        return Country(
            name = name,
            region = region,
            code = code,
            capital = capital
        )
    }
}