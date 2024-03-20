package com.example.weather.features.sevenday.data.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SevenDaysWeatherResponse(
    val location: Location,
    val forecast: Forecast,
)

@JsonClass(generateAdapter = true)
data class Location(
    val name: String,
)

@JsonClass(generateAdapter = true)
data class Forecast(
    val forecastday: List<ForecastDay>,
)

@JsonClass(generateAdapter = true)
data class ForecastDay(
    val date: String,
    val day: Day,
)

@JsonClass(generateAdapter = true)
data class Day(
    val avgtemp_c: Double,
    val condition: Condition,
)

@JsonClass(generateAdapter = true)
data class Condition(
    val text: String,
)
