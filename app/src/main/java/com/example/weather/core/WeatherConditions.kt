package com.example.weather.core

import com.example.weather.R

object WeatherConditions {
    val nameToDrawableRes =
        hashMapOf(
            "Sunny" to R.drawable.sunyy,
            "Cloudy" to R.drawable.cloudy,
            "Partly cloudy" to R.drawable.cloudy,
            "Clear" to R.drawable.clear,
            "Windy" to R.drawable.wind,
            "Thunderstorm" to R.drawable.thunder,
            "Snow" to R.drawable.snow,
        )

    fun parseToIcon(value: String): Int {
        if (nameToDrawableRes.containsKey(value)) {
            return nameToDrawableRes[value]!!
        }
        return R.drawable.clear
    }
}
