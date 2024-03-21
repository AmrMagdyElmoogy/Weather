package com.example.weather.features.sevenday.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weather.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SevenDaysListWeather(
    city: String,
    modifier: Modifier = Modifier,
) {
    val viewModel: SevenDaysViewModel = hiltViewModel()
    val state by viewModel.uiState.collectAsState()
    LaunchedEffect(key1 = true) {
        viewModel.init(city.substringBefore(','))
    }
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
            Text(
                stringResource(R.string.happy_week_from) + ' ' + city,
                style = MaterialTheme.typography.titleMedium,
                modifier = modifier.padding(bottom = 10.dp),
            )
        }
        items(state.weather.size) { index ->
            WeatherDayItem(weather = state.weather[index])
        }
    }
}
