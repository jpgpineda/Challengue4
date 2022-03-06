package com.example.challengue4.data.network

import com.example.weather.Network.WeatherEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("data/2.5/weather")
    suspend fun getWeatherById(
        @Query("id") lon: Long,
        @Query("units") units: String?,
        @Query("lang") lang: String?,
        @Query("appid") appid: String?): WeatherEntity
}