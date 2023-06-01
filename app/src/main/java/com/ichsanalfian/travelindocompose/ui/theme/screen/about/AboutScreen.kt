package com.ichsanalfian.travelindocompose.ui.theme.screen.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ichsanalfian.travelindocompose.R
import com.ichsanalfian.travelindocompose.ui.theme.TravelIndoComposeTheme

@Composable
fun AboutScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.my_photo),
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Muhammad Ichsan Alfian",
            style = MaterialTheme.typography.h5
        )
        Text(
            text = "ichsanalfian@student.telkomuniversity.ac.id",
            style = MaterialTheme.typography.body1
        )
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun PlaceListItemPreview() {
    TravelIndoComposeTheme {
        AboutScreen()
    }
}