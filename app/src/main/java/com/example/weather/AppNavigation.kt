package com.example.weather

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weather.core.ScreensDestinations
import com.example.weather.features.home.presentation.HomeScreen
import com.example.weather.features.sevenday.SevenDaysWeatherScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreensDestinations.HOME.path) {
        composable(ScreensDestinations.HOME.path) {
            HomeScreen {
                navController.navigate(ScreensDestinations.SEVENDAYSFORECAST.path)
            }
        }

        composable(ScreensDestinations.SEVENDAYSFORECAST.path) {
            SevenDaysWeatherScreen()
        }
    }
}
