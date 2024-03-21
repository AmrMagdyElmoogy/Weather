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
        imageVector = ImageVector.vectorResource(id = WeatherConditions.parseToIcon(condition)),
        contentDescription = null,
        modifier = modifier.size(200.dp),
    )
}
