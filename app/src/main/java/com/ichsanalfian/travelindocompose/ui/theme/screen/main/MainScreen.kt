package com.ichsanalfian.travelindocompose.ui.theme.screen.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ichsanalfian.travelindocompose.di.Injection
import com.ichsanalfian.travelindocompose.model.Place
import com.ichsanalfian.travelindocompose.ui.theme.ViewModelFactory
import com.ichsanalfian.travelindocompose.ui.theme.common.UiState
import com.ichsanalfian.travelindocompose.ui.theme.component.PlaceItem
import com.ichsanalfian.travelindocompose.ui.theme.component.SearchBar

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navigateToDetail: (String) -> Unit,
) {
    val groupedPlaces by viewModel.groupedPlaces.collectAsState()
    val query by viewModel.query
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getAllRewards()
            }
            is UiState.Success -> {
                Column{
                    SearchBar(query = query, onQueryChange =viewModel::searchPlace )
                    repeat(groupedPlaces.size) {
                        MainContent(
                            places = uiState.data,
                            modifier = modifier,
                            navigateToDetail = navigateToDetail,
                            query = query
                        )

                    }
                }


            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun MainContent(
    places: List<Place>,
    modifier: Modifier,
    navigateToDetail: (String) -> Unit,
    query : String,
) {
    Box(modifier = modifier) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(160.dp),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier
        ) {
            val filteredPlaces = places.filter { place ->
                place.name.contains(query, ignoreCase = true)
            }
            items(filteredPlaces, key = { it.id }) { place ->
                PlaceItem(
                    name = place.name,
                    location = place.location,
                    photoUrl = place.photoUrl,
                    onItemClick = { navigateToDetail(place.id) }
                )
            }
        }
    }
}