package com.example.weather.DomainObject

import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.weather.Network.*
import java.util.*
import java.util.jar.Attributes
import kotlin.math.roundToInt

data class WeatherEntityDTO(val weatherEntity: WeatherEntity) {
    val main: MainDTO
    val sys: SysDTO
    val name: String
    val weather: List<WeatherDTO>
    val wind: WindDTO
    val dt: Long

    val formattedDate: String
    @RequiresApi(Build.VERSION_CODES.N)
    get() = SimpleDateFormat("dd/mm hh:mm a", Locale.ENGLISH).format(Date(weatherEntity.dt*1000))

    init {
        main = MainDTO(weatherEntity.main)
        sys = SysDTO(weatherEntity.sys)
        name = weatherEntity.name
        weather = listOf(WeatherDTO(weatherEntity.weather.first()))
        wind = WindDTO(weatherEntity.wind)
        dt = weatherEntity.dt
    }
}
