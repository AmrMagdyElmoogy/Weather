package com.example.weather

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weather.core.ScreensDestinations
import com.example.weather.features.home.presentation.HomeScreen
import com.example.weather.features.sevenday.presentation.SevenDaysWeatherScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreensDestinations.HOME.path) {
        composable(ScreensDestinations.HOME.path) {
            HomeScreen {
                navController.navigate("moreForcasts/$it")
            }
        }

        composable("moreForcasts/{args1}") {
            val arg1 = it.arguments?.getString("args1") ?: "Cairo"
            SevenDaysWeatherScreen(arg1)
        }
    }
}
