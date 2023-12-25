package com.shobhit97.countryapp.domain.repository

import com.shobhit97.countryapp.domain.model.Country
import kotlinx.coroutines.flow.Flow

interface CountryRepo {

    suspend fun getCountries()

    fun getAllCountries():Flow<List<Country>>
}