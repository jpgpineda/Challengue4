package com.example.challengue4.domain.useCase

import com.example.challengue4.data.WeatherRepository
import com.example.weather.DomainObject.WeatherEntityDTO

class GetWeatherByIdUseCase {
    private val repository = WeatherRepository()

    suspend operator fun invoke(id: Long, units: String, lang: String, appid: String): WeatherEntityDTO? =  repository.getWeatherById(id, units, lang, appid)
}