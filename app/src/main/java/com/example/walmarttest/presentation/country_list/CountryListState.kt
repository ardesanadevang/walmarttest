package com.example.walmarttest.presentation.country_list

import com.example.walmarttest.domain.model.Country

data class CountryListState(
    val countries: List<Country> = emptyList()
)
