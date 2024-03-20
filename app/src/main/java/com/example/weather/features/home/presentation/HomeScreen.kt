package com.example.weather.features.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigateToSevenDaysForecastScreen: () -> Unit,
) {
    var value by
        remember {
            mutableStateOf(TextFieldValue(text = ""))
        }

    val viewModel: HomeViewModel = hiltViewModel()
    val state by viewModel.uiState.collectAsState()
    Scaffold(
        containerColor = Color.Transparent,
        bottomBar = {
            AdditionalWeatherInfo(weather = state.weather)
        },
        topBar = {
            TextInput(
                value = value,
                onValueChange = {
                    value = it
                },
                onDoneClick = {
                    viewModel.getWeatherOf(value.text)
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
                    onNavigateToSevenDaysForecastScreen()
                })
            }
        }
    }
}
