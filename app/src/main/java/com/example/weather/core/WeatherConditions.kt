package com.example.weather.core

import androidx.annotation.DrawableRes
import com.example.weather.R

enum class WeatherConditions(
    @DrawableRes val res: Int,
) {
    Sunny(R.drawable.sunyy),
    Cloudy(R.drawable.cloudy),
    Rainy(R.drawable.rain),
    Snowy(R.drawable.snow),
    Windy(R.drawable.windy),
    Clear(R.drawable.clear),
    Thunderstorm(R.drawable.thunder),
}
