package com.example.weather.features.home.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.R
import com.example.weather.core.inTemperatureDegree
import com.example.weather.features.home.domin.entities.OneDayWeather

@Composable
fun TodayWeatherSummary(
    modifier: Modifier = Modifier,
    weather: OneDayWeather,
    onNavigateToSevenDaysForecast: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            weather.temperature.inTemperatureDegree(),
            style =
                MaterialTheme.typography.titleLarge.copy(
                    fontSize = 80.sp,
                ),
        )
        Text(weather.condition, style = MaterialTheme.typography.titleMedium)
        Text(
            weather.localtime,
            style = MaterialTheme.typography.labelSmall,
            color = Color.Gray,
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier.clickable { onNavigateToSevenDaysForecast() },
        ) {
            Text(
                text = stringResource(R.string.next_7_days),
                style =
                    MaterialTheme.typography.titleMedium.copy(
                        brush = Brush.horizontalGradient(listOf(Color.Red, Color.Gray)),
                    ),
            )
            Icon(
                imageVector = Icons.Filled.ArrowForward,
                contentDescription = null,
            )
        }
    }
}

fun String.customDateAndTimeWeather(): String {
    val month = substring(5..6).toInt()
    val day = substring(8..9).toInt()
    val customizeResult = StringBuffer()
    customizeResult.apply {
        append(month.determineMonth())
        append(' ')
        append(day)
        append('|')
        append(this.takeLast(5).toString().toAMOrPM())
    }
    return customizeResult.toString()
}

fun String.toAMOrPM(): String {
    var firstTwoDigits = substring(0..1).toInt()
    if (firstTwoDigits > 12) {
        firstTwoDigits = -12
        return firstTwoDigits.toString() + substring(3) + "PM"
    }
    return this + "AM"
}

fun Int.determineMonth(): String {
    return when (this) {
        1 -> "January"
        2 -> "February"
        3 -> "March"
        4 -> "April"
        5 -> "May"
        6 -> "June"
        7 -> "July"
        8 -> "August"
        9 -> "September"
        10 -> "October"
        11 -> "November"
        else -> "December"
    }
}
