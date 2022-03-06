package com.example.weather.DomainObject

import com.example.weather.Network.Main

data class MainDTO(val mainEntity: Main) {
    val temp: Double
    val feelsLike: Double
    val tempMin: Double
    val tempMax: Double
    val pressure: Int
    val humidity: Int

    init {
        temp = mainEntity.temp
        feelsLike = mainEntity.feels_like
        tempMin = mainEntity.temp_min
        tempMax = mainEntity.temp_max
        pressure = mainEntity.pressure
        humidity = mainEntity.humidity
    }
}
