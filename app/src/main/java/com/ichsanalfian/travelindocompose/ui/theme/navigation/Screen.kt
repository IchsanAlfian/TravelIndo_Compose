package com.ichsanalfian.travelindocompose.ui.theme.navigation

sealed class Screen(val route: String) {
    object About : Screen("about")
    object Main : Screen("main")
    object DetailPlace : Screen("main/{placeId}") {
        fun createRoute(placeId: String) = "main/$placeId"
    }
}