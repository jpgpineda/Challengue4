package com.example.challengue4.service

import com.example.challengue4.data.network.RetrofitInstance
import com.example.challengue4.data.network.WeatherAPI
import com.example.weather.Network.WeatherEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import java.lang.Error

class WeatherServiceNetwork {
    private val retrofit = RetrofitInstance.getRetrofit().create(WeatherAPI::class.java)

    suspend fun getWeatherById(id: Long, units: String, lang: String, appid: String): WeatherEntity? {
        return withContext(Dispatchers.IO) {
            val response = retrofit.getWeatherById(id, units, lang, appid)
            response.body()
        }
    }
}