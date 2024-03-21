package com.example.weather.features.home.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CityWeather")
data class CityWeatherTable(
    @PrimaryKey val id: Int = 1,
    val location: String,
    val temperature: String,
    val localtime: String,
    val condition: String,
    val sunrise: String,
    val sunset: String,
    val windMph: String,
    val humidity: String,
    val feelsLike: String,
    val uv: String,
)
