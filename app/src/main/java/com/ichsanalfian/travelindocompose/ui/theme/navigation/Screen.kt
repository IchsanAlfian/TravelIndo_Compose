package com.ichsanalfian.travelindocompose.ui.theme.navigation

sealed class Screen(val route: String) {
    object Main : Screen("main")
    object DetailPlace : Screen("detailplace")
}