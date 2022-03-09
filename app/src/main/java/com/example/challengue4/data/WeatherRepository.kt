package com.example.challengue4.data

import com.example.challengue4.data.model.WeatherProvider
import com.example.challengue4.service.WeatherServiceNetwork
import com.example.weather.DomainObject.WeatherEntityDTO

class WeatherRepository {
    private val api = WeatherServiceNetwork()

    suspend fun getWeatherById(id: Long, units: String, lang: String, appid: String): WeatherEntityDTO? {
        val response = api.getWeatherById(id, units, lang, appid)
        if (response != null) {
            val weather = WeatherEntityDTO(response)
            WeatherProvider.weather = weather
            return weather
        }
        return null
    }
}