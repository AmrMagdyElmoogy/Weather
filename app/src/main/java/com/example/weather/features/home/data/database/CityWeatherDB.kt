package com.example.weather.features.home.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weather.features.home.data.dto.CityWeatherTable

@Database(entities = [CityWeatherTable::class], version = 1)
abstract class CityWeatherDB : RoomDatabase() {
    abstract fun dao(): CityWeatherDao
}
