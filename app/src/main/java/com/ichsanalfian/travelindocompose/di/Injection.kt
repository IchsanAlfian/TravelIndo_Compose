package com.ichsanalfian.travelindocompose.di

import com.ichsanalfian.travelindocompose.data.TravelRepository

object Injection {
    fun provideRepository(): TravelRepository {
        return TravelRepository.getInstance()
    }
}