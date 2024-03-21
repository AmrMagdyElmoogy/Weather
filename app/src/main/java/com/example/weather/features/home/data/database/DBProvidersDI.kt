package com.example.weather.features.home.data.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBProvidersDI {
    @Provides
    @Singleton
    fun provideRoomDatabase(
        @ApplicationContext context: Context,
    ): CityWeatherDB {
        return Room.databaseBuilder(
            context,
            CityWeatherDB::class.java,
            "Weather",
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideDaoInstance(db: CityWeatherDB): CityWeatherDao {
        return db.dao()
    }
}
