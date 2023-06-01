package com.ichsanalfian.travelindocompose.data

import com.ichsanalfian.travelindocompose.model.Place
import com.ichsanalfian.travelindocompose.model.PlaceData
import kotlinx.coroutines.flow.flowOf

class TravelRepository {
    fun getAllPlace() = flowOf(PlaceData.places)
    fun getDetailPlace(placeId: String): Place = PlaceData.places.first {
        it.id == placeId
    }

    fun getPlaces(): List<Place> {
        return PlaceData.places
    }

    fun searchPlaces(query: String): List<Place> {
        return PlaceData.places.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }

    companion object {
        @Volatile
        private var instance: TravelRepository? = null

        fun getInstance(): TravelRepository =
            instance ?: synchronized(this) {
                TravelRepository().apply {
                    instance = this
                }
            }
    }
}