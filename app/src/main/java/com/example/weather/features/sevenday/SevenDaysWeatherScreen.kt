package com.example.weather.features.sevenday

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SevenDaysWeatherScreen(modifier: Modifier = Modifier) {
    val list = createWeatherDays()
    Surface(
        modifier = modifier.fillMaxSize(),
        contentColor = Color.White,
    ) {
        SevenDaysListWeather(weatherDays = list)
    }
}
