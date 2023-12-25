package com.shobhit97.countryapp.domain.model

data class CountriesInfo(
    val `data`: List<Country>,
    val message: String,
    val status: Int
)