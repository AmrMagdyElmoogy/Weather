package com.example.weather.features.sevenday

import androidx.annotation.DrawableRes
import com.example.weather.R

data class WeatherDay(
    val dayOfWeek: String,
    @DrawableRes val weatherIcon: Int,
    val weatherDescription: String,
    val temperature: String,
)

fun createWeatherDays(): List<WeatherDay> {
    val weatherDays = mutableListOf<WeatherDay>()
    val icons =
        listOf(
            R.drawable.sunyy,
            R.drawable.cloudy,
            R.drawable.rain,
            R.drawable.thunder,
            R.drawable.sunyy,
        )
    val daysOfWeek = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")

    for (i in 0 until 7) {
        val dayOfWeek = daysOfWeek[i]
        val weatherIcon = icons[i % icons.size]
        val temperature =
            "${(20..30).random()} C"
        weatherDays.add(WeatherDay("$dayOfWeek ${i + 1}", weatherIcon, "Sunny", temperature))
    }

    return weatherDays
}
