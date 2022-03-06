package com.example.weather.DomainObject

import com.example.weather.Network.Wind

data class WindDTO(val windEntity: Wind) {
    val speed: Double

    init {
        speed = windEntity.speed
    }
}
