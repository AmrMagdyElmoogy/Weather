package com.example.weather.features.sevenday.presentation

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.R
import com.example.weather.core.NetworkError
import com.example.weather.core.ResultHandling
import com.example.weather.features.sevenday.domin.SevenDaysWeather
import com.example.weather.features.sevenday.domin.SevenDaysWeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SevenDaysViewModel
    @Inject
    constructor(
        private val repo: SevenDaysWeatherRepository,
    ) : ViewModel() {
        private var _uiState = MutableStateFlow(SevenDaysUiState())
        val uiState = _uiState.asStateFlow()

        @StringRes
        var errorMessage: Int = R.string.Error_404
            private set

        init {
            viewModelScope.launch {
                _uiState.update {
                    it.copy(
                        isLoading = true,
                    )
                }
                when (val result = repo.fetchSevenDays("Cairo")) {
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
                                NetworkError.EMPTY_RESULT -> R.string.Error_Empty_Result
                            }
                    }
                }
            }
        }
    }

data class SevenDaysUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val weather: List<SevenDaysWeather> =
        emptyList(),
)
