package com.example.weatherrain.data.repository

import com.example.weatherrain.data.model.WeatherInfo

interface WeatherRepository {

    suspend fun getWeatherData(lat: Float, lng: Float) : WeatherInfo

}