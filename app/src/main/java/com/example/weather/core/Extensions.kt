package com.example.weather.core

import com.example.weather.features.home.presentation.determineMonth

fun String.inTemperatureDegree(): String = "$this\u00B0C"

fun String.getMonthAndDay(): String {
    val month = substring(5..6).toInt()
    val day = substring(8..9).toInt()
    return month.determineMonth() + ' ' + day.toString()
}
