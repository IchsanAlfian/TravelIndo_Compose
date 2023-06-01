package com.ichsanalfian.travelindocompose.ui.theme.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ichsanalfian.travelindocompose.data.TravelRepository
import com.ichsanalfian.travelindocompose.model.Place
import com.ichsanalfian.travelindocompose.ui.theme.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: TravelRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<Place>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<Place>>>
        get() = _uiState

    fun getAllRewards() {
        viewModelScope.launch {
            repository.getAllPlace()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { places ->
                    _uiState.value = UiState.Success(places)
                }
        }
    }

}