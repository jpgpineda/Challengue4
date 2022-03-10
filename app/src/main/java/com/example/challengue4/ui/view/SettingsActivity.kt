package com.example.challengue4.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import coil.load
import com.example.challengue4.R
import com.example.challengue4.core.utils.LanguageType
import com.example.challengue4.core.utils.PreferencesKeys
import com.example.challengue4.core.utils.PreferencesRepository.Companion.prefs
import com.example.challengue4.core.utils.getEnumType
import com.example.challengue4.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding
    private val defaultLanguage = "es"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
    }

    fun setupView() {
        setLanguages()
        binding.apply {
            measurementSwitch.isChecked = prefs.getBooleanValue(PreferencesKeys.METRIC)
            settingsImageView.load("https://images.ctfassets.net/hrltx12pl8hq/6TIZLa1AKeBel0yVO7ReIn/1fc0e2fd9fcc6d66b3cc733aa2547e11/weather-images.jpg?fit=fill&w=800&h=300")
            backButton.setOnClickListener {
                saveLenguageSelected()
                saveMetricSelected()
                finish()
            }
        }
    }

    private fun setLanguages() {
        var language: String = prefs.getStringValue(PreferencesKeys.LANGUAGE)

        if (language.isEmpty()) {
            language = defaultLanguage
            binding.spanishButton.isChecked = true
        } else {
            val languageType = getEnumType(language)
            when (languageType) {
                LanguageType.SPANISH -> binding.spanishButton.isChecked = true
                LanguageType.ENGLISH -> binding.englishButton.isChecked = true
                LanguageType.FRENCH -> binding.frenchButton.isChecked = true
            }
        }
    }

    private fun saveMetricSelected() {
        prefs.saveBooleanValue(PreferencesKeys.METRIC, binding.measurementSwitch.isChecked)
    }

    private fun saveLenguageSelected() {
        val selectedOption: Int = binding.radioGroup.checkedRadioButtonId
        val radioButton = findViewById<RadioButton>(selectedOption)
        val checked = radioButton.isChecked
        when (radioButton.id) {
            R.id.spanish_button -> if (checked)  {
                prefs.saveStringValue(PreferencesKeys.LANGUAGE,LanguageType.SPANISH.type)
            }
            R.id.english_button -> if (checked) {
                prefs.saveStringValue(PreferencesKeys.LANGUAGE,LanguageType.ENGLISH.type)
            }
            R.id.french_button -> if (checked) {
                prefs.saveStringValue(PreferencesKeys.LANGUAGE,LanguageType.FRENCH.type)
            }
        }
    }
}