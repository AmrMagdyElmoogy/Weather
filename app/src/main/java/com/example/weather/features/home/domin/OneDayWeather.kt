package com.example.weather.features.home.domin

data class OneDayWeather(
    val temperature: Double,
    val location: String,
    val region: String,
    val localtime: String,
    val condition: String,
    val sunrise: String,
    val sunset: String,
    val windMph: Double,
    val humidity: Int,
    val feelsLike: Double,
    val uv: Double,
)
