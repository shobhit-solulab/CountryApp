package com.shobhit97.countryapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shobhit97.countryapp.domain.model.Country
import com.shobhit97.countryapp.domain.repository.CountryRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CountryViewModel @Inject constructor(
     val countryRepo:CountryRepo
): ViewModel() {

     init {
         viewModelScope.launch {
            countryRepo.getCountries()
         }
     }

    fun getAllCountries():Flow<List<Country>> {
        return countryRepo.getAllCountries()
    }

}