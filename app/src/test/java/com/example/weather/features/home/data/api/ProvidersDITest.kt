package com.example.weather.features.home.data.api

import com.example.weather.core.BASE_URL
import dagger.hilt.android.testing.HiltAndroidTest
import okhttp3.OkHttpClient
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@RunWith(MockitoJUnitRunner::class)
@HiltAndroidTest
class ProvidersDITest {
    @Mock
    lateinit var mockOkHttpClient: OkHttpClient

    @Test
    fun `test Retrofit instance is provided`() {
        // Given
        val retrofit = ProvidersDI.provideRetrofitInstance(mockOkHttpClient)

        // Then
        assert(retrofit.baseUrl().toString() == BASE_URL)
    }

    @Test
    fun `test OneDayWeatherClientApi instance is provided`() {
        // Given
        val retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .client(mockOkHttpClient)
                .build()

        val service = retrofit.create(OneDayCityWeatherService::class.java)

        val oneDayWeatherClientApi = ProvidersDI.provideOneDayWeatherClientApi(retrofit)

        // Then
        assertEquals(service::class, oneDayWeatherClientApi::class)
    }

    @Test
    fun `test retrofit instance is provided`() {
        // Given
        val retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .client(mockOkHttpClient)
                .build()

        val retrofitProvided = ProvidersDI.provideRetrofitInstance(mockOkHttpClient)

        // Then
        assertEquals(retrofit::class, retrofitProvided::class)
    }
}
