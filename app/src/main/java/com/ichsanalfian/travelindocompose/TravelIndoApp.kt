package com.ichsanalfian.travelindocompose

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ichsanalfian.travelindocompose.ui.theme.TravelIndoComposeTheme
import com.ichsanalfian.travelindocompose.ui.theme.navigation.NavigationItem
import com.ichsanalfian.travelindocompose.ui.theme.navigation.Screen
import com.ichsanalfian.travelindocompose.ui.theme.screen.about.AboutScreen
import com.ichsanalfian.travelindocompose.ui.theme.screen.detailPlace.DetailPlaceScreen
import com.ichsanalfian.travelindocompose.ui.theme.screen.main.MainScreen

@Composable
fun TravelIndoApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.DetailPlace.route) {
                BottomBar(navController)
            }
        },
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
                        navController.navigate(Screen.DetailPlace.createRoute(it))
                    }
                )
            }
            composable(Screen.About.route) {
                AboutScreen(
                )
            }
            composable(
                route = Screen.DetailPlace.route,
                arguments = listOf(navArgument("placeId") { type = NavType.StringType }),
            ) {
                val id = it.arguments?.getString("placeId") ?: -1L
                DetailPlaceScreen(
                    placeId = id as String,
                    navigateBack = {
                        navController.navigateUp()
                    },

                    )
            }
        }
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    BottomNavigation(
        modifier = modifier,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigationItems = listOf(
            NavigationItem(
                title = "Home",
                icon = Icons.Default.Home,
                screen = Screen.Main,
                contentDescription = "Home/Main Page"
            ),
            NavigationItem(
                title = "About Me",
                icon = Icons.Default.Person,
                screen = Screen.About,
                contentDescription = "about_page"
            ),
        )
        BottomNavigation {
            navigationItems.map { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title
                        )
                    },
                    label = { Text(item.title) },
                    selected = currentRoute == item.screen.route,
                    onClick = {
                        navController.navigate(item.screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TravelIndoAppPreview() {
    TravelIndoComposeTheme {
        TravelIndoApp()
    }
}

