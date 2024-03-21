package com.example.weather.features.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigateToSevenDaysForecastScreen: (String) -> Unit,
) {
    val viewModel: HomeViewModel = hiltViewModel()
    val state by viewModel.uiState.collectAsState()
    val value = viewModel.query
    Scaffold(
        containerColor = Color.Transparent,
        bottomBar = {
            AdditionalWeatherInfo(weather = state.weather)
        },
        topBar = {
            TextInput(
                value = value,
                onValueChange = {
                    viewModel.updateQueryOfCity(it)
                },
                onDoneClick = {
                    viewModel.getWeatherOfQuery()
                },
            )
        },
        modifier =
            Modifier
                .fillMaxSize(),
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier =
                modifier
                    .padding(it)
                    .fillMaxWidth()
                    .padding(15.dp),
        ) {
            if (state.isLoading) {
                Box(modifier = modifier.fillMaxSize().align(Alignment.CenterHorizontally)) {
                    CircularProgressIndicator()
                }
            } else if (state.isError) {
                Box(modifier = modifier.fillMaxSize().align(Alignment.CenterHorizontally)) {
                    Text(
                        stringResource(id = viewModel.errorMessage),
                        style = MaterialTheme.typography.titleMedium,
                    )
                }
            } else {
                WeatherIcon(condition = state.weather.condition)
                TodayWeatherSummary(weather = state.weather, onNavigateToSevenDaysForecast = {
                    onNavigateToSevenDaysForecastScreen(state.weather.location)
                })
            }
        }
    }
}
