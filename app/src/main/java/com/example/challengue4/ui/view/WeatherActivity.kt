package com.example.challengue4.ui.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import com.example.challengue4.R
import com.example.challengue4.databinding.ActivityWeatherBinding
import com.example.challengue4.ui.viewModel.WeatherViewModel

class WeatherActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeatherBinding
    private val weatherViewModel: WeatherViewModel by viewModels()
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        weatherViewModel.onCreate(324232, "", "", "")
        setupObservers()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun setupObservers() {
        weatherViewModel.weatherModel.observe(this, Observer { weatherDTO ->
            binding.apply {
                locationTextView.text = weatherDTO.formattedLocation
                temperatureTextView.text = weatherDTO.main.formattedTemp
                descriptionTextView.text = weatherDTO.weather.first().description
                minTempTextView.text = weatherDTO.main.formattedMinTemp
                maxTempTextView.text = weatherDTO.main.formattedMaxTemp
                sunriseTextView.text = weatherDTO.sys.formattedSunrise
                sunsetTextView.text = weatherDTO.sys.formattedSunset
                humidityTextView.text = weatherDTO.main.formattedHumidity
                pressureTextView.text = weatherDTO.main.formattedPressure
                windTextView.text = weatherDTO.wind.formattedSpeed
            }
        })
    }
}