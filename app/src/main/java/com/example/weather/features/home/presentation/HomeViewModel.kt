package com.example.weather.features.home.presentation

import androidx.annotation.StringRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.R
import com.example.weather.core.DatabaseError
import com.example.weather.core.NetworkError
import com.example.weather.core.ResultHandling
import com.example.weather.core.ResultHandling.Success
import com.example.weather.features.home.domin.OneDayWeatherRepository
import com.example.weather.features.home.domin.entities.OneDayWeather
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

        var query by mutableStateOf(TextFieldValue(text = ""))
            private set

        val defaultWeather =
            OneDayWeather(
                temperature = "25.5",
                location = "New York",
                localtime = "2024-03-20 12:00 PM",
                condition = "Sunny",
                sunrise = "06:30 AM",
                sunset = "07:00 PM",
                windMph = "10.2",
                humidity = "60",
                feelsLike = "28.0",
                uv = "7.5",
            )

        init {
            viewModelScope.launch {
                when (val result = repo.selectCachedWeatherCity()) {
                    is ResultHandling.Failure -> {
                        val error = result.error
                        when (error) {
                            DatabaseError.SQLiteException -> {
                            }

                            DatabaseError.RoomDatabaseException -> {}
                            DatabaseError.IllegalArgumentException -> {
                            }

                            DatabaseError.InvalidQueryException -> {}
                        }
                    }

                    is Success -> {
                        val weather = result.data
                        weather.collect {
                            query =
                                TextFieldValue(
                                    it?.location ?: query.text,
                                    selection = TextRange(it?.location?.length ?: query.text.length),
                                )
                            _uiState.update { state ->
                                state.copy(
                                    weather =
                                        it ?: defaultWeather,
                                )
                            }
                        }
                    }
                }
            }
        }

        @StringRes
        var errorMessage: Int = R.string.Error_404
            private set

        fun getWeatherOfQuery() {
            viewModelScope.launch {
                _uiState.update {
                    it.copy(
                        isError = false,
                        isLoading = true,
                    )
                }
                when (val result = repo.fetchOneDayWeather(query.text)) {
                    is Success -> {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
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
                                NetworkError.EMPTY_RESULT -> R.string.Error_Empty_Result
                            }
                    }
                }
            }
        }

        fun updateQueryOfCity(text: TextFieldValue) {
            query = text
        }
    }

data class HomeUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val weather: OneDayWeather =
        OneDayWeather(
            temperature = "25.5",
            location = "New York",
            localtime = "2024-03-20 12:00 PM",
            condition = "Sunny",
            sunrise = "06:30 AM",
            sunset = "07:00 PM",
            windMph = "10.2",
            humidity = "60",
            feelsLike = "28.0",
            uv = "7.5",
        ),
)
