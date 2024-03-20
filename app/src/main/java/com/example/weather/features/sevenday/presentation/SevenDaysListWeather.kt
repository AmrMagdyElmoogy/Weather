package com.example.weather.features.sevenday.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weather.features.sevenday.WeatherDay

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SevenDaysListWeather(
    modifier: Modifier = Modifier,
    weatherDays: List<WeatherDay>,
) {
    val viewModel: SevenDaysViewModel = hiltViewModel()
    val state by viewModel.uiState.collectAsState()
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        modifier =
            modifier
                .fillMaxSize()
                .background(
                    brush =
                        Brush.verticalGradient(
                            listOf(
                                Color(33, 32, 58, 255),
                                Color(54, 29, 86, 255),
                                Color.Black,
                            ),
                        ),
                ),
    ) {
        stickyHeader {
            Text("Happy week from Cairo!", style = MaterialTheme.typography.titleMedium)
        }
        items(state.weather.size) { index ->
            WeatherDayItem(weather = state.weather[index])
            if (index < weatherDays.size - 1) {
                Divider(
                    color = Color.LightGray,
                    thickness = 1.dp,
                )
            }
        }
    }
}
