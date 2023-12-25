package com.shobhit97.countryapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shobhit97.countryapp.domain.model.Country

@Database(entities = [Country::class],version = 1)
abstract class CountryDatabase:RoomDatabase(){
    abstract fun countryDao():CountryDao
}