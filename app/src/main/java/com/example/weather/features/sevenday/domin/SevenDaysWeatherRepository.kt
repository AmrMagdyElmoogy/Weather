package com.example.weather.features.sevenday.domin

import android.util.Log
import com.example.weather.core.NetworkError
import com.example.weather.core.ResultHandling
import com.example.weather.features.sevenday.data.api.SevenDayCityWeatherService
import com.example.weather.features.sevenday.data.dto.toSevenDaysEntity
import java.io.IOException
import javax.inject.Inject

class SevenDaysWeatherRepository
    @Inject
    constructor(
        private val api: SevenDayCityWeatherService,
    ) : SevenDaysWeatherDomain {
        override suspend fun fetchSevenDays(city: String): ResultHandling<List<SevenDaysWeather>, NetworkError> {
            return try {
                val result = api.fetchSevenDaysCityWeather(city)
                if (result.isSuccessful) {
                    val newResponse = mutableListOf<SevenDaysWeather>()
                    val oldResponse = result.body()
                    oldResponse?.let {
                        it.data.weather.forEach { weather ->
                            newResponse.add(weather.toSevenDaysEntity())
                        }
                    }
                    ResultHandling.Success(newResponse.toList())
                } else {
                    ResultHandling.Failure(NetworkError.EMPTY_RESULT)
                }
            } catch (e: IOException) {
                println(e.printStackTrace())
                return ResultHandling.Failure(NetworkError.NO_INTERNET)
            } catch (e: Exception) {
                Log.d("SevenDaysException", e.toString())
                return ResultHandling.Failure(NetworkError.UNKNOWN)
            }
        }
    }
