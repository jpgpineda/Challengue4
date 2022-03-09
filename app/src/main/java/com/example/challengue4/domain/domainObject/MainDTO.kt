package com.example.weather.DomainObject

import com.example.weather.Network.Main
import kotlin.math.roundToInt

data class MainDTO(val mainEntity: Main) {
    val temp: Double
    val feelsLike: Double
    val tempMin: Double
    val tempMax: Double
    val pressure: Int
    val humidity: Int

    val formattedTemp: String
    get() = "${temp.roundToInt()} ºC"

    val formattedMinTemp: String
    get() = "Minima: ${tempMin.toInt()} ºC"

    val formattedMaxTemp: String
    get() = "Maxima: ${tempMax.toInt()} ºC"

    val formattedPressure: String
    get() = "$pressure mb"

    val formattedHumidity: String
    get() = "$humidity %"

    val formattedFeelsLike: String
    get() = "Sensación: ${feelsLike.toInt()} ºC"

    init {
        temp = mainEntity.temp
        feelsLike = mainEntity.feels_like
        tempMin = mainEntity.temp_min
        tempMax = mainEntity.temp_max
        pressure = mainEntity.pressure
        humidity = mainEntity.humidity
    }
}
