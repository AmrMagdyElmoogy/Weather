package com.example.weather.features.home.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weather.R
import com.example.weather.core.inTemperatureDegree
import com.example.weather.features.home.domin.OneDayWeather
import com.example.weather.ui.theme.montserratFont

@Composable
fun AdditionalWeatherInfo(
    modifier: Modifier = Modifier,
    weather: OneDayWeather,
) {
    Card(
        colors =
            CardDefaults.cardColors(
                containerColor = Color.Transparent,
            ),
        modifier =
            modifier
                .fillMaxWidth()
                .padding(16.dp),
    ) {
        Row(
            modifier =
                modifier
                    .fillMaxWidth()
                    .padding(8.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = modifier.weight(1f),
            ) {
                TodayWeatherSummary(
                    res = R.drawable.sunrise,
                    title = stringResource(R.string.sunrise),
                    description = weather.sunrise,
                )

                TodayWeatherSummary(
                    res = R.drawable.sunyy,
                    title = stringResource(R.string.uv),
                    description = weather.uv.toString(),
                )
                TodayWeatherSummary(
                    res = R.drawable.windy,
                    title = stringResource(R.string.e_wind),
                    description = weather.windMph.toString(),
                )
            }
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = modifier.weight(1f),
            ) {
                TodayWeatherSummary(
                    res = R.drawable.sunset_svgrepo_com,
                    title = stringResource(R.string.sunset),
                    description = weather.sunset,
                )
                TodayWeatherSummary(
                    res = R.drawable.temperature,
                    title = stringResource(R.string.feels_like),
                    description = weather.feelsLike.inTemperatureDegree(),
                )
                TodayWeatherSummary(
                    res = R.drawable.humidity,
                    title = stringResource(R.string.humidity),
                    description = weather.humidity.toString(),
                )
            }
        }
    }
}

@Composable
private fun TodayWeatherSummary(
    modifier: Modifier = Modifier,
    @DrawableRes res: Int,
    title: String,
    description: String,
) {
    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
    ) {
        Image(
            modifier = modifier.size(50.dp),
            imageVector = ImageVector.vectorResource(res),
            contentDescription = null,
        )
        Column(
            modifier = modifier.padding(start = 8.dp),
        ) {
            Text(
                title,
                style = MaterialTheme.typography.bodySmall,
                fontFamily = montserratFont,
                fontWeight = FontWeight.Light,
                color = Color.Gray,
            )
            Text(
                description,
                style =
                    MaterialTheme.typography.bodySmall,
            )
        }
    }
}
