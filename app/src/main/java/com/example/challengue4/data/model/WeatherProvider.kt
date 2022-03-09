package com.example.challengue4.data.model

import com.example.weather.DomainObject.WeatherEntityDTO
import com.example.weather.Network.WeatherEntity

class WeatherProvider {
    companion object {
        var weather: WeatherEntityDTO? = null
    }
}