package com.example.weather.features.home.domin

import android.database.sqlite.SQLiteException
import android.util.Log
import com.example.weather.core.DatabaseError
import com.example.weather.core.NetworkError
import com.example.weather.core.ResultHandling
import com.example.weather.features.home.data.api.OneDayCityWeatherService
import com.example.weather.features.home.data.database.CityWeatherDao
import com.example.weather.features.home.data.dto.toOneDayEntity
import com.example.weather.features.home.data.dto.toTableEntity
import com.example.weather.features.home.data.dto.toUIEntity
import com.example.weather.features.home.domin.entities.OneDayWeather
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.io.IOException
import java.sql.SQLDataException
import java.sql.SQLException
import javax.inject.Inject

class OneDayWeatherRepository
    @Inject
    constructor(
        private val dao: CityWeatherDao,
        private val api: OneDayCityWeatherService,
    ) : OneDayWeatherDomain {
        override suspend fun fetchOneDayWeather(city: String): ResultHandling<OneDayWeather, NetworkError> {
            return try {
                val result = api.fetchOneDayCityWeather(city)
                if (result.isSuccessful) {
                    val success = result.body()!!.toOneDayEntity()
                    insertNewWeatherData(weather = success)
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

        override suspend fun insertNewWeatherData(weather: OneDayWeather) {
            try {
                dao.insertNewWeatherData(weather.toTableEntity())
            } catch (e: SQLDataException) {
                Log.d("RoomException", e.toString())
            } catch (e: SQLException) {
                Log.d("RoomException", e.toString())
            }
        }

        override suspend fun selectCachedWeatherCity(): ResultHandling<Flow<OneDayWeather?>, DatabaseError> {
            return try {
                val result =
                    dao.selectCachedCityWeather().map { table ->
                        table?.toUIEntity()
                    }
                ResultHandling.Success(result)
            } catch (e: IllegalArgumentException) {
                return ResultHandling.Failure(DatabaseError.IllegalArgumentException)
            } catch (e: SQLiteException) {
                return ResultHandling.Failure(DatabaseError.SQLiteException)
            }
        }
    }
