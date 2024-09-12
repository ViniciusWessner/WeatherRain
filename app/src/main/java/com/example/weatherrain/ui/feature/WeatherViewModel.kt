package com.example.weatherrain.ui.feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherrain.data.model.WeatherInfo
import com.example.weatherrain.data.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
) : ViewModel() {

    private val _weatherInfoState = MutableStateFlow(WeatherInfoState())
    val weatherInfoState: StateFlow<WeatherInfoState> = _weatherInfoState.asStateFlow()

    init {
        getWeatherInfo()
    }

    private fun getWeatherInfo() {
        viewModelScope.launch {
            val weatherInfo = weatherRepository.getWeatherData(-23.53005275349876f, -46.78954773970684f)
            _weatherInfoState.update {
                it.copy(weatherInfo = weatherInfo)
            }
        }
    }
}