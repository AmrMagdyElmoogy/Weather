package com.example.weather.core

import com.example.weather.R

object WeatherConditions {
    val nameToDrawableRes =
        hashMapOf(
            "sunny" to R.drawable.sunyy,
            "cloudy" to R.drawable.cloudy,
            "partly cloudy" to R.drawable.cloudy,
            "clear" to R.drawable.clear,
            "windy" to R.drawable.wind,
            "thunderstorm" to R.drawable.thunder,
            "patchy rain nearby" to R.drawable.raining,
            "rain" to R.drawable.rain,
            "snow" to R.drawable.snow,
            "fog" to R.drawable.fog,
        )

    fun parseToIcon(value: String): Int {
        val valueLC = value.trim().lowercase()
        if (nameToDrawableRes.containsKey(valueLC)) {
            return nameToDrawableRes[valueLC]!!
        }
        return R.drawable.clear
    }
}
