package com.example.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.example.weather.ui.theme.WeatherTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {
    val gradientBrush =
        Brush.verticalGradient(listOf(Color(33, 32, 58, 255), Color(54, 29, 86, 255), Color.Black))
    WeatherTheme {
        Surface(
            contentColor = Color.White,
            color = Color.Transparent,
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(brush = gradientBrush),
        ) {
            AppNavigation()
        }
    }
}
