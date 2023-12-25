package com.shobhit97.countryapp.data.repository

import android.util.Log
import com.shobhit97.countryapp.data.local.CountryDao
import com.shobhit97.countryapp.data.remote.CountryApi
import com.shobhit97.countryapp.domain.model.Country
import com.shobhit97.countryapp.domain.repository.CountryRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CountryRepoImpl @Inject constructor(
     val countryApi:CountryApi,
     val countryDao: CountryDao
):CountryRepo {
    override suspend fun getCountries() {
        try {
            val result = countryApi.getCountries()
            if(result.isSuccessful) {
                result.body()?.let { countryDao.saveCountries(it.data) }
//                Log.d("API DATA", "getCountries: ${res} ")
            }
        } catch(e:Exception) {
            Log.d("Exception", "getCountries: ${e.localizedMessage} ")
        }
    }

    override fun getAllCountries(): Flow<List<Country>> {
        return  countryDao.getAllCountries()
    }

}