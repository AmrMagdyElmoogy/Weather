package com.example.weather.features.sevenday.data.dto

import com.example.weather.features.sevenday.domin.SevenDaysWeather

fun Weather.toSevenDaysEntity(): SevenDaysWeather {
    return SevenDaysWeather(
        location = "",
        temperature = temperature,
        date = date,
        condition = hourly[0].weatherDesc[0].value,
    )
}
