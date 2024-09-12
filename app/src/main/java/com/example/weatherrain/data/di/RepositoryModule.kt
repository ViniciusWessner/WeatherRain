package com.example.weatherrain.data.di

import com.example.weatherrain.data.repository.WeatherRepository
import com.example.weatherrain.data.repository.WeatherRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    fun bindWeatherRepository(repositoryImpl: WeatherRepositoryImpl) : WeatherRepository
}