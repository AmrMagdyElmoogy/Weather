package com.example.weather.features.home.presentation

import androidx.compose.ui.text.input.TextFieldValue
import com.example.weather.core.ResultHandling
import com.example.weather.features.home.domin.OneDayWeatherRepository
import com.example.weather.features.home.domin.entities.OneDayWeather
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class HomeViewModelTest {
    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.IO)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `Test successful data retrieve`() {
        val repo = mockk<OneDayWeatherRepository>()

        val expectedWeather =
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

        coEvery { repo.selectCachedWeatherCity() } returns
            ResultHandling.Success(
                flowOf(
                    expectedWeather,
                ),
            )

        val viewModel = HomeViewModel(repo)

        assertEquals(
            HomeUiState(weather = expectedWeather),
            viewModel.uiState.value,
        )
    }

    @Test
    fun `Test query update`() {
        val repo = mockk<OneDayWeatherRepository>()

        val viewModel = HomeViewModel(repo)
        val newText = TextFieldValue("London")
        viewModel.updateQueryOfCity(newText)

        assertEquals(
            newText,
            viewModel.query,
        )
    }
}
