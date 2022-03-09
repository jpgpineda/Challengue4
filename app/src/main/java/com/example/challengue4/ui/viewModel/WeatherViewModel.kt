package com.example.challengue4.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challengue4.R
import com.example.challengue4.domain.useCase.GetLocalWeatherInfoUseCase
import com.example.challengue4.domain.useCase.GetWeatherByIdUseCase
import com.example.weather.DomainObject.WeatherEntityDTO
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {
    var weatherModel = MutableLiveData<WeatherEntityDTO>()
    var error = MutableLiveData<Int>()
    var isLoading = MutableLiveData<Boolean>()

    var getWeatherByIdUseCase = GetWeatherByIdUseCase()
    var getLocalWeatherInfoUseCase = GetLocalWeatherInfoUseCase()

    fun onCreate(id: Long, units: String, lang: String, appid: String) {
        val weather = getLocalWeather()
        if (weather != null) {
            weatherModel.postValue(weather!!)
        } else {
            viewModelScope.launch {
                isLoading.postValue(true)
                val result = getWeatherByIdUseCase(id, units, lang, appid)
                if (result != null) {
                    weatherModel.postValue(result!!)
                    isLoading.postValue(false)
                } else {
                    error.postValue(R.string.networkErrorOcurred)
                    isLoading.postValue(false)
                }
            }
        }
    }

    fun getLocalWeather(): WeatherEntityDTO? {
        return getLocalWeatherInfoUseCase.invoke()
    }
}