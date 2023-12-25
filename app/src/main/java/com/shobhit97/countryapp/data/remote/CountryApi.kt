package com.shobhit97.countryapp.data.remote

import com.shobhit97.countryapp.domain.model.CountriesInfo
import retrofit2.Response
import retrofit2.http.GET

interface CountryApi {

    @GET("mylocalbusiness/getCountries")
    suspend fun getCountries():Response<CountriesInfo>
}