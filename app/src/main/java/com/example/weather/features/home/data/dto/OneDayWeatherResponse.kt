package com.example.weather.features.home.data.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OneDayWeatherResponse(
    val location: Location,
    val current: Current,
    val forecast: Forecast,
)

@JsonClass(generateAdapter = true)
data class Location(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    val localtime: String,
)

@JsonClass(generateAdapter = true)
data class Current(
    val temp_c: Double,
    val is_day: Int,
    val condition: Condition,
    val wind_mph: Double,
    val humidity: Int,
    val feelslike_c: Double,
    val uv: Double,
)

@JsonClass(generateAdapter = true)
data class Condition(
    val text: String,
)

@JsonClass(generateAdapter = true)
data class Forecast(
    val forecastday: List<ForecastDay>,
)

@JsonClass(generateAdapter = true)
data class ForecastDay(
    val date: String,
    val astro: Astro,
//    val hour: List<Hour>
)

@JsonClass(generateAdapter = true)
data class Astro(
    val sunrise: String,
    val sunset: String,
)

data class Hour(
    val time_epoch: Long,
    val time: String,
    val temp_c: Double,
    val temp_f: Double,
    val is_day: Int,
    val condition: Condition,
    val wind_mph: Double,
    val wind_kph: Double,
    val wind_degree: Int,
    val wind_dir: String,
    val pressure_mb: Double,
    val pressure_in: Double,
    val precip_mm: Double,
    val precip_in: Double,
    val snow_cm: Double,
    val humidity: Int,
    val cloud: Int,
    val feelslike_c: Double,
    val feelslike_f: Double,
    val windchill_c: Double,
    val windchill_f: Double,
    val heatindex_c: Double,
    val heatindex_f: Double,
    val dewpoint_c: Double,
    val dewpoint_f: Double,
    val will_it_rain: Int,
    val chance_of_rain: Int,
    val will_it_snow: Int,
    val chance_of_snow: Int,
    val vis_km: Double,
    val vis_miles: Double,
    val gust_mph: Double,
    val gust_kph: Double,
    val uv: Double,
)
