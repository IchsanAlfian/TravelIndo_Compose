package com.ichsanalfian.travelindocompose.data
import com.ichsanalfian.travelindocompose.model.Place
import com.ichsanalfian.travelindocompose.model.PlaceData

import kotlinx.coroutines.flow.flowOf

class TravelRepository {

    fun getAllPlace() = flowOf(PlaceData.places)
    fun getDetailPlace(placeId: String): Place = PlaceData.places.first{
            it.id == placeId
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