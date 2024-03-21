package com.example.weather.features.sevenday.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.weather.core.WeatherConditions
import com.example.weather.core.getMonthAndDay
import com.example.weather.core.inTemperatureDegree
import com.example.weather.features.sevenday.domin.SevenDaysWeather

@Composable
fun WeatherDayItem(
    weather: SevenDaysWeather,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.padding(4.dp),
        colors =
            CardDefaults.cardColors(
                containerColor =
                    Color.Transparent.copy(alpha = 0.2f),
                contentColor = Color.White,
            ),
    ) {
        Row(
            modifier =
                modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp, horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                weather.date.getMonthAndDay(),
                style = MaterialTheme.typography.bodySmall,
                modifier = modifier.weight(1.5f),
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier.weight(1.5f),
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(WeatherConditions.parseToIcon(weather.condition)),
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
}
