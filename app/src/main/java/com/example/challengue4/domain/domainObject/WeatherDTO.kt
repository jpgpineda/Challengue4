package com.example.weather.DomainObject

import com.example.weather.Network.Weather

data class WeatherDTO(val weather: Weather) {
    val main: String
    val description: String
    val icon: String

    init {
        main = weather.main
        description = weather.description
        icon = weather.icon
    }
}
