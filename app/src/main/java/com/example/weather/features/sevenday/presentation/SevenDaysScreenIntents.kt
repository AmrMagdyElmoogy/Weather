package com.example.weather.features.sevenday.presentation

sealed interface SevenDaysScreenIntents {
    data class GetListOfSevenDaysWeather(val city: String) : SevenDaysScreenIntents
}
