package com.example.weather.features.home.presentation

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.R
import com.example.weather.core.NetworkError
import com.example.weather.core.ResultHandling
import com.example.weather.features.home.domin.OneDayWeather
import com.example.weather.features.home.domin.OneDayWeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
    @Inject
    constructor(
        private val repo: OneDayWeatherRepository,
    ) : ViewModel() {
        private var _uiState = MutableStateFlow(HomeUiState())
        val uiState = _uiState.asStateFlow()

        @StringRes
        var errorMessage: Int = R.string.Error_404
            private set

        fun getWeatherOf(city: String) {
            viewModelScope.launch {
                _uiState.update {
                    it.copy(
                        isLoading = true,
                    )
                }
                when (val result = repo.fetchOneDayWeather(city)) {
                    is ResultHandling.Success -> {
                        val data = result.data
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                weather = data,
                            )
                        }
                    }

                    is ResultHandling.Failure -> {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                isError = true,
                            )
                        }
                        val error = result.error
                        errorMessage =
                            when (error) {
                                NetworkError.UNKNOWN -> R.string.Error_UNKNOWN
                                NetworkError.JSON_NOT_PARSING -> R.string.Error_Parsing
                                NetworkError.NO_INTERNET -> R.string.Error_Internet
                                NetworkError.NOT_FOUND_404 -> R.string.Error_404
                            }
                    }
                }
            }
        }
    }

data class HomeUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val weather: OneDayWeather =
        OneDayWeather(
            temperature = 25.5,
            location = "New York",
            region = "NY",
            localtime = "2024-03-20 12:00 PM",
            condition = "Sunny",
            sunrise = "06:30 AM",
            sunset = "07:00 PM",
            windMph = 10.2,
            humidity = 60,
            feelsLike = 28.0,
            uv = 7.5,
        ),
)
