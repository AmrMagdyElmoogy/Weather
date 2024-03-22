package com.example.weather.features.home.data.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DBProvidersDITest {
    private lateinit var context: Context
    private lateinit var cityWeatherDB: CityWeatherDB
    private lateinit var cityWeatherDao: CityWeatherDao

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
        cityWeatherDB =
            Room.inMemoryDatabaseBuilder(context, CityWeatherDB::class.java)
                .allowMainThreadQueries()
                .build()
        cityWeatherDao = cityWeatherDB.dao()
    }

    @After
    fun tearDown() {
        cityWeatherDB.close()
    }

    @Test
    fun `Testing provideRoomDatabase`() {
        val roomDatabase = DBProvidersDI.provideRoomDatabase(context)
        assertNotNull(roomDatabase)
    }

    @Test
    fun `Testing provideDaoInstance`() {
        val daoInstance = DBProvidersDI.provideDaoInstance(cityWeatherDB)

        assertNotNull(daoInstance)
    }
}
