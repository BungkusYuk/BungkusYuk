package com.example.segarbox.core.data.source.remote.network

import com.example.segarbox.BuildConfig
import com.example.segarbox.core.data.source.remote.response.MapsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MapsApiServices {

    @GET("json")
    suspend fun getAddress(
        @Query("latlng") latLng: String,
        @Query("key") apiKey: String = BuildConfig.GOOGLE_MAPS_KEY,
    ): Response<MapsResponse>

}