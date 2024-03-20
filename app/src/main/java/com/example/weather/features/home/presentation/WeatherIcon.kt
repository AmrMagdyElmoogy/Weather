package com.example.weather.features.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.weather.core.WeatherConditions

@Composable
fun WeatherIcon(
    condition: String,
    modifier: Modifier = Modifier,
) {
    Image(
        imageVector = ImageVector.vectorResource(id = condition.parseToIcon()),
        contentDescription = null,
        modifier = modifier.size(200.dp),
    )
}

private fun String.parseToIcon(): Int {
    return when (this) {
        WeatherConditions.Sunny.name -> WeatherConditions.Sunny.res
        WeatherConditions.Cloudy.name -> WeatherConditions.Cloudy.res
        WeatherConditions.Rainy.name -> WeatherConditions.Rainy.res
        WeatherConditions.Snowy.name -> WeatherConditions.Snowy.res
        WeatherConditions.Windy.name -> WeatherConditions.Windy.res
        WeatherConditions.Clear.name -> WeatherConditions.Clear.res
        WeatherConditions.Thunderstorm.name -> WeatherConditions.Thunderstorm.res
        // Add other cases as needed
        else -> WeatherConditions.Sunny.res
    }
}
