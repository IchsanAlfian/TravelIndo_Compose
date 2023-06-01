package com.ichsanalfian.travelindocompose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ichsanalfian.travelindocompose.component.PlaceItem
import com.ichsanalfian.travelindocompose.model.PlaceData
import com.ichsanalfian.travelindocompose.ui.theme.TravelIndoComposeTheme

@Composable
fun TravelIndoApp(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(160.dp),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier
        ) {
            items(PlaceData.places, key = { it.id}) { place ->
                PlaceItem(
                    name = place.name,
                    location = place.location,
                    photoUrl = place.photoUrl,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun TravelIndoAppPreview(){
    TravelIndoComposeTheme {
        TravelIndoApp()
    }
}

