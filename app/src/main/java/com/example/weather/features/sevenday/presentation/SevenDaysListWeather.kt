package com.example.weather.features.sevenday.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weather.R
import com.example.weather.core.HandlingUiStates
import com.example.weather.core.LottieLoader

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SevenDaysListWeather(
    city: String,
    onPressBackToHomeScreen: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val viewModel: SevenDaysViewModel = hiltViewModel()
    val state by viewModel.uiState.collectAsState()
    LaunchedEffect(key1 = true) {
        viewModel.intentChannel.send(SevenDaysScreenIntents.GetListOfSevenDaysWeather(city))
    }

    Scaffold(
        containerColor = Color.Transparent,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "${stringResource(id = R.string.happy_week_from)} $city",
                        style =
                            MaterialTheme.typography.titleMedium.copy(
                                fontSize = 20.sp,
                            ),
                    )
                },
                navigationIcon = {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = null,
                        tint = Color.White,
                        modifier =
                            modifier.size(30.dp).clickable {
                                onPressBackToHomeScreen()
                            },
                    )
                },
                colors =
                    TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent,
                    ),
                modifier = modifier.padding(horizontal = 8.dp),
            )
        },
        modifier =
            Modifier
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
    ) { paddingValues ->
        HandlingUiStates(
            state = state,
            onLoading = {
                Box(
                    modifier =
                        modifier
                            .padding(paddingValues)
                            .fillMaxSize(),
                ) {
                    LottieLoader(
                        res = R.raw.loading,
                        modifier = modifier.align(Alignment.Center),
                    )
                }
            },
            onError = {
                Column(
                    modifier =
                        modifier
                            .padding(paddingValues)
                            .fillMaxSize(),
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
                LazyColumn(
                    contentPadding = paddingValues,
                    modifier =
                        modifier
                            .padding(16.dp).fillMaxSize(),
                ) {
                    items(state.weather.size) { index ->
                        WeatherDayItem(weather = state.weather[index])
                    }
                }
            },
        )
    }
}
