package com.example.weather.core

import com.example.weather.features.home.presentation.determineMonth

fun Double.inTemperatureDegree(): String = toInt().toString() + "\u00B0C"

fun String.parseToIcon(): Int {
    return when (this) {
        WeatherConditions.Sunny.name -> WeatherConditions.Sunny.res
        WeatherConditions.Cloudy.name -> WeatherConditions.Cloudy.res
        WeatherConditions.Rainy.name -> WeatherConditions.Rainy.res
        WeatherConditions.Snowy.name -> WeatherConditions.Snowy.res
        WeatherConditions.Windy.name -> WeatherConditions.Windy.res
        WeatherConditions.Clear.name -> WeatherConditions.Clear.res
        WeatherConditions.Thunderstorm.name -> WeatherConditions.Thunderstorm.res
        else -> WeatherConditions.Sunny.res
    }
}

fun String.getMonthAndDay(): String {
    val month = substring(5..6).toInt()
    val day = substring(8..9).toInt()
    return month.determineMonth() + ' ' + day.toString()
}
