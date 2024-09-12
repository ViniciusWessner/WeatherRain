package com.example.weatherrain.data.remote

import com.example.weatherrain.data.remote.response.WeatherDataResponse

interface RemoteDataSource {

    suspend fun getWeatherDataResponse(lat: Float, Lng: Float): WeatherDataResponse

}