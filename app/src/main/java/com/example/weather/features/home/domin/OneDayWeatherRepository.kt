package com.example.weather.features.home.domin

import com.example.weather.core.NetworkError
import com.example.weather.core.ResultHandling
import com.example.weather.features.home.data.api.OneDayCityWeatherService
import com.example.weather.features.home.data.dto.toOneDayEntity
import java.io.IOException
import javax.inject.Inject

class OneDayWeatherRepository
    @Inject
    constructor(
        private val api: OneDayCityWeatherService,
    ) : OneDayWeatherDomain {
        override suspend fun fetchOneDayWeather(city: String): ResultHandling<OneDayWeather, NetworkError> {
            return try {
                val result = api.fetchOneDayCityWeather(city)
                if (result.isSuccessful) {
                    val success = result.body()!!.toOneDayEntity()
                    ResultHandling.Success(success)
                } else {
                    ResultHandling.Failure(NetworkError.JSON_NOT_PARSING)
                }
            } catch (e: IOException) {
                println(e.printStackTrace())
                return ResultHandling.Failure(NetworkError.NO_INTERNET)
            } catch (e: Exception) {
                return ResultHandling.Failure(NetworkError.UNKNOWN)
            }
        }
    }
