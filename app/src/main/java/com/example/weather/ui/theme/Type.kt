package com.example.weather.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.weather.R

val montserratFont =
    FontFamily(
        Font(R.font.montserrat, FontWeight.Normal),
        Font(R.font.montserrat_light, FontWeight.Light),
        Font(R.font.montserrat_medium, FontWeight.Medium),
        Font(R.font.montserrat_thin, FontWeight.Thin),
    )

val Typography =
    Typography(
        bodyLarge =
            TextStyle(
                fontFamily = montserratFont,
                fontWeight = FontWeight.Medium,
                fontSize = 25.sp,
                lineHeight = 20.sp,
                textAlign = TextAlign.Start,
                letterSpacing = 0.5.sp,
            ),
        labelLarge =
            TextStyle(
                fontFamily = montserratFont,
                fontWeight = FontWeight.Thin,
                color = Color.LightGray,
                fontSize = 16.sp,
                textAlign = TextAlign.Start,
                letterSpacing = 0.5.sp,
            ),
        labelSmall =
            TextStyle(
                fontFamily = montserratFont,
                fontWeight = FontWeight.Thin,
                color = Color.LightGray,
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                letterSpacing = 0.5.sp,
            ),
        bodyMedium =
            TextStyle(
                fontFamily = montserratFont,
                fontWeight = FontWeight.Light,
                fontSize = 20.sp,
                lineHeight = 20.sp,
                textAlign = TextAlign.Start,
                letterSpacing = 0.5.sp,
            ),
        bodySmall =
            TextStyle(
                fontFamily = montserratFont,
                fontWeight = FontWeight.Light,
                fontSize = 18.sp,
                lineHeight = 20.sp,
                textAlign = TextAlign.Start,
                letterSpacing = 0.5.sp,
            ),
        headlineLarge =
            TextStyle(
                fontFamily = montserratFont,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                lineHeight = 24.sp,
                textAlign = TextAlign.Center,
                letterSpacing = 0.5.sp,
            ),
        titleMedium =
            TextStyle(
                fontFamily = montserratFont,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                fontSize = 28.sp,
                lineHeight = 28.sp,
                letterSpacing = 0.sp,
            ),
        titleLarge =
            TextStyle(
                fontFamily = montserratFont,
                fontWeight = FontWeight.Normal,
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
                lineHeight = 28.sp,
                letterSpacing = 0.sp,
            ),
    )
