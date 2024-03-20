package com.example.weather.features.sevenday.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.weather.core.getMonthAndDay
import com.example.weather.core.inTemperatureDegree
import com.example.weather.core.parseToIcon
import com.example.weather.features.sevenday.domin.SevenDaysWeather

@Composable
fun WeatherDayItem(
    weather: SevenDaysWeather,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier =
            modifier
                .padding(vertical = 30.dp)
                .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            weather.localtime.getMonthAndDay(),
            style = MaterialTheme.typography.bodyMedium,
            modifier = modifier.weight(1f),
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier.weight(1f),
        ) {
            Image(
                imageVector = ImageVector.vectorResource(weather.condition.parseToIcon()),
                contentDescription = null,
                modifier = modifier.size(30.dp),
            )
            Text(weather.condition, style = MaterialTheme.typography.labelLarge)
        }

        Text(
            weather.temperature.inTemperatureDegree(),
            style = MaterialTheme.typography.headlineLarge,
            modifier = modifier.weight(1f),
        )
    }
}
