package com.example.weather.core

sealed interface ErrorHandling

sealed interface ResultHandling<out D, out E : ErrorHandling> {
    data class Success<out D, out E : ErrorHandling>(val data: D) : ResultHandling<D, E>

    data class Failure<out D, out E : ErrorHandling>(val error: E) : ResultHandling<D, E>
}

enum class NetworkError : ErrorHandling {
    UNKNOWN,
    JSON_NOT_PARSING,
    NO_INTERNET,
    NOT_FOUND_404,
}
