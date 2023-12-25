package com.shobhit97.countryapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.shobhit97.countryapp.domain.model.Country
import kotlinx.coroutines.flow.Flow


@Dao
interface CountryDao {

    @Insert
    suspend fun saveCountries(countries:List<Country>)

    @Query("SELECT * FROM country")
    fun getAllCountries(): Flow<List<Country>>
}