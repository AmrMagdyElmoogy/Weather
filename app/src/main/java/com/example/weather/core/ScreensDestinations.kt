package com.example.weather.core

enum class ScreensDestinations(val path: String) {
    HOME("/home"),
    MORE_FORECASTS("/moreForcasts/{args1}"),
    ;

    fun withArg(arg: String): String {
        return path.replace("{args1}", arg)
    }
}
