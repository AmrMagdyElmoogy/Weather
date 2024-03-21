package com.example.weather.features.home.domin.entities

data class OneDayWeather(
    val temperature: String,
    val location: String,
    val localtime: String,
    val condition: String,
    val sunrise: String,
    val sunset: String,
    val windMph: String,
    val humidity: String,
    val feelsLike: String,
    val uv: String,
)
