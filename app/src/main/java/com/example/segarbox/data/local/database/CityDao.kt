package com.example.segarbox.data.local.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.segarbox.data.remote.response.CityResults

@Dao
interface CityDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCity(cityResults: List<CityResults>)

    @Query("SELECT COUNT(*) FROM city")
    fun getCityCount(): LiveData<Int>

    @Query("SELECT * FROM city WHERE cityName = :city AND type = :type")
    fun getCity(city: String, type: String): LiveData<List<CityResults>>
}