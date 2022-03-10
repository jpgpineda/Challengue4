package com.example.challengue4.ui.view

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import com.example.challengue4.R
import com.example.challengue4.core.utils.*
import com.example.challengue4.core.utils.PreferencesRepository.Companion.prefs
import com.example.challengue4.databinding.ActivityWeatherBinding
import com.example.challengue4.ui.viewModel.WeatherViewModel

class WeatherActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeatherBinding
    val metric = "metric"
    val imperial = "imperial"
    val defaultLanguage = "es"
    private val weatherViewModel: WeatherViewModel by viewModels()
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var language: String = prefs.getStringValue(PreferencesKeys.LANGUAGE)
        if (language.isEmpty()) {
            language = defaultLanguage
        }
        val metrics: String = if (prefs.getBooleanValue(PreferencesKeys.METRIC)) imperial else metric
        weatherViewModel.onCreate(3530597L, metrics, language, "6cd8e4cfa8706c26d9e895b454c1ad8e")
        setupObservers()
        setupView()
    }

    private fun setupView() {
        binding.settingsButton.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
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