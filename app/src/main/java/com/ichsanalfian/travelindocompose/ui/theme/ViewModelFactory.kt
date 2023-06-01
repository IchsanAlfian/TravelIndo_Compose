package com.ichsanalfian.travelindocompose.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ichsanalfian.travelindocompose.data.TravelRepository
import com.ichsanalfian.travelindocompose.ui.theme.screen.detailPlace.DetailPlaceViewModel
import com.ichsanalfian.travelindocompose.ui.theme.screen.main.MainViewModel

class ViewModelFactory(private val repository: TravelRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailPlaceViewModel::class.java)) {
            return DetailPlaceViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}