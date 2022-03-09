package com.example.challengue4.domain.useCase

import com.example.challengue4.data.model.WeatherProvider
import com.example.weather.DomainObject.WeatherEntityDTO

class GetLocalWeatherInfoUseCase {
    operator fun invoke(): WeatherEntityDTO? = WeatherProvider.weather
}