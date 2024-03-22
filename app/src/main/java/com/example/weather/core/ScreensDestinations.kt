package com.example.weather.core

enum class ScreensDestinations(val path: String) {
    HOME("/home"),
    MORE_FORECASTS("/moreForcasts/{args1}"),
    ;

    fun withArgs(vararg args: String): String {
        return path.format(*args)
    }
}
