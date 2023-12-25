package com.shobhit97.countryapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shobhit97.countryapp.data.local.CountryDao
import com.shobhit97.countryapp.data.local.CountryDatabase
import com.shobhit97.countryapp.data.remote.CountryApi
import com.shobhit97.countryapp.data.repository.CountryRepoImpl
import com.shobhit97.countryapp.domain.repository.CountryRepo
import com.shobhit97.countryapp.utility.AppConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApi(): CountryApi {
        return Retrofit
            .Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountryApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context) : CountryDatabase {
        return  Room.databaseBuilder(
            context,
            CountryDatabase::class.java,
            "country_db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideCountryDao(database:CountryDatabase): CountryDao {
        return database.countryDao()
    }

    @Singleton
    @Provides
    fun getRepo(countryApi: CountryApi, countryDao: CountryDao ):CountryRepo {
        return  CountryRepoImpl(countryApi,countryDao)
    }


}