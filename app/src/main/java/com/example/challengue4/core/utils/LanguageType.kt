package com.example.challengue4.core.utils

enum class LanguageType(val type: String) {
    SPANISH("es"),
    ENGLISH("en"),
    FRENCH("fr");

    companion object {
        private val map = values().associateBy(LanguageType::type)
        fun fromType(type: String) = map[type]
    }
}

fun getEnumType(type: String): LanguageType? = LanguageType.fromType(type)