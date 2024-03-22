package com.example.weather.features.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weather.R
import com.example.weather.core.HandlingUiStates
import com.example.weather.core.LottieLoader
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

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
            HandlingUiStates(
                state = state,
                onLoading = { },
                onError = { },
            ) {
                AdditionalWeatherInfo(weather = state.weather)
            }
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
                onRemoveTextInput = {
                    viewModel.clearTextInput()
                },
            )
        },
        modifier =
            Modifier
                .fillMaxSize(),
    ) {
        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing = viewModel.refresh.collectAsState().value),
            onRefresh = {
                viewModel.resetRefreshIndicator()
            },
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier =
                    modifier
                        .padding(it)
                        .fillMaxWidth()
                        .padding(15.dp)
                        .verticalScroll(rememberScrollState()),
            ) {
                HandlingUiStates(
                    state = state,
                    onLoading = {
                        Box(modifier = modifier.fillMaxSize()) {
                            LottieLoader(
                                res = R.raw.loading,
                                modifier = modifier.align(Alignment.Center),
                            )
                        }
                    },
                    onError = {
                        Column(
                            modifier = modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            LottieLoader(res = R.raw.error)
                            Text(
                                stringResource(id = viewModel.errorMessage),
                                style = MaterialTheme.typography.titleMedium,
                            )
                        }
                    },
                    onSuccess = {
                        WeatherIcon(condition = state.weather.condition)
                        TodayWeatherSummary(
                            weather = state.weather,
                            onNavigateToSevenDaysForecast = {
                                onNavigateToSevenDaysForecastScreen(state.weather.location)
                            },
                        )
                    },
                )
            }
        }
    }
}
