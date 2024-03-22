package com.example.weather.core

import androidx.compose.runtime.Composable
import com.example.weather.features.home.presentation.HomeUiState
import com.example.weather.features.home.presentation.determineMonth
import com.example.weather.features.sevenday.presentation.SevenDaysUiState

fun String.inTemperatureDegree(): String = "$this\u00B0C"

@Composable
inline fun <reified T : Any> HandlingUiStates(
    state: T,
    onLoading: @Composable () -> Unit,
    onError: @Composable () -> Unit,
    onSuccess: @Composable (T) -> Unit,
) {
    when (state) {
        is SevenDaysUiState -> {
            when {
                state.isLoading -> onLoading()
                state.isError -> onError()
                else -> onSuccess(state as T)
            }
        }
        is HomeUiState -> {
            when {
                state.isLoading -> onLoading()
                state.isError -> onError()
                else -> onSuccess(state as T)
            }
        }
    }
}

fun String.getMonthAndDay(): String {
    val month = substring(5..6).toInt()
    val day = substring(8..9).toInt()
    return month.determineMonth() + ' ' + day.toString()
}
