package com.example.walmarttest.presentation.country_list

import com.example.walmarttest.domain.dto.Country

data class CountryListState(
    val countries: List<Country> = emptyList()
)
