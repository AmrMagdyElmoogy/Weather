package com.example.weather.features.home.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weather.features.home.data.dto.CityWeatherTable
import kotlinx.coroutines.flow.Flow

@Dao
interface CityWeatherDao {
    @Query("Select * From CityWeather")
    fun selectCachedCityWeather(): Flow<CityWeatherTable?>

    @Insert(entity = CityWeatherTable::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewWeatherData(weather: CityWeatherTable)
}
