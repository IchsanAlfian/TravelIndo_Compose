package com.ichsanalfian.travelindocompose.ui.theme.screen.detailPlace

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ichsanalfian.travelindocompose.data.TravelRepository
import com.ichsanalfian.travelindocompose.model.Place
import com.ichsanalfian.travelindocompose.ui.theme.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailPlaceViewModel (
    private val repository: TravelRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<Place>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<Place>>
        get() = _uiState
    fun getDetailPlace(placeId: String) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getDetailPlace(placeId))
        }
    }
}