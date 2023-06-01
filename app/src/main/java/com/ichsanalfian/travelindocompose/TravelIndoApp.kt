package com.ichsanalfian.travelindocompose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ichsanalfian.travelindocompose.ui.theme.component.PlaceItem
import com.ichsanalfian.travelindocompose.model.PlaceData
import com.ichsanalfian.travelindocompose.ui.theme.TravelIndoComposeTheme
import com.ichsanalfian.travelindocompose.ui.theme.navigation.Screen
import com.ichsanalfian.travelindocompose.ui.theme.screen.main.MainScreen

@Composable
fun TravelIndoApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Main.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Main.route) {
                MainScreen(
                    navigateToDetail = {
                    }
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

