package com.example.weather.DomainObject

import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.weather.Network.Sys
import java.util.*

data class SysDTO(val sysEntity: Sys) {
    val country: String
    val sunrise: Long
    val sunset: Long

    val formatSunset: String
    @RequiresApi(Build.VERSION_CODES.N)
    get() = SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunset*1000))

    val formatSunrise: String
    @RequiresApi(Build.VERSION_CODES.N)
    get() = SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunrise*1000))

    init {
        country = sysEntity.country
        sunrise = sysEntity.sunrise
        sunset = sysEntity.sunset
    }
}
