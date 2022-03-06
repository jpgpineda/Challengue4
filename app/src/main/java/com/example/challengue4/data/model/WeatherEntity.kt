package com.example.weather.Network

import java.util.*

data class WeatherEntity(
    val base: String,
    val main: Main,
    val sys: Sys,
    val name: String,
    val weather: List<Weather>,
    val wind: Wind,
    val dt: Long
)
