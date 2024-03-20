package com.example.weather.features.sevenday.data.dto

import com.example.weather.features.sevenday.domin.SevenDaysWeather

fun SevenDaysWeatherResponse.toSevenDaysEntity(
    index: Int,
    forecastDay: ForecastDay,
): SevenDaysWeather {
    return SevenDaysWeather(
        location = location.name,
        temperature = forecastDay.day.avgtemp_c,
        localtime = forecastDay.date,
        condition = forecastDay.day.condition.text,
    )
}
