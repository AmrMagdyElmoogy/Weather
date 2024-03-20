package com.example.weather.features.home.data.dto

import com.example.weather.features.home.domin.OneDayWeather

fun OneDayWeatherResponse.toOneDayEntity(): OneDayWeather =
    OneDayWeather(
        temperature = current.temp_c,
        location = location.country,
        region = location.name,
        localtime = location.localtime,
        condition = current.condition.text,
        sunrise = forecast.forecastday[0].astro.sunrise,
        sunset = forecast.forecastday[0].astro.sunset,
        windMph = current.wind_mph,
        humidity = current.humidity,
        feelsLike = current.feelslike_c,
        uv = current.uv,
    )
