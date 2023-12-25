package com.shobhit97.countryapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Country(
    @PrimaryKey
    val countries_id: String,
    val countries_iso_code: String,
    val countries_name: String,
    val country_code: String,
    val flag: String
)