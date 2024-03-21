package com.example.weather.features.home.data.dto

import com.example.weather.features.home.domin.entities.OneDayWeather

fun OneDayWeatherResponse.toOneDayEntity(): OneDayWeather =
    OneDayWeather(
        temperature = data.condition[0].temperature,
        location = data.request[0].query,
        localtime = data.condition[0].observationTime,
        condition = data.condition[0].weatherDesc[0].value,
        sunrise = data.weather[0].astronomy[0].sunrise,
        sunset = data.weather[0].astronomy[0].sunset,
        windMph = data.condition[0].windMph,
        humidity = data.condition[0].humidity,
        feelsLike = data.condition[0].feelsLike,
        uv = data.condition[0].uvIndex,
    )

fun OneDayWeather.toTableEntity() =
    CityWeatherTable(
        temperature = temperature,
        location = location,
        localtime = localtime,
        condition = condition,
        sunrise = sunrise,
        sunset = sunset,
        windMph = windMph,
        humidity = humidity,
        feelsLike = feelsLike,
        uv = uv,
    )

fun CityWeatherTable.toUIEntity() =
    OneDayWeather(
        temperature = temperature,
        location = location,
        localtime = localtime,
        condition = condition,
        sunrise = sunrise,
        sunset = sunset,
        windMph = windMph,
        humidity = humidity,
        feelsLike = feelsLike,
        uv = uv,
    )
