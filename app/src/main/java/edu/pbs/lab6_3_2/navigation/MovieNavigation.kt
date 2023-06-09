package edu.pbs.lab6_3_2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import edu.pbs.lab6_3_2.screens.detals.DetailsScreen
import edu.pbs.lab6_3_2.screens.home.HomeScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name
    ) {
        composable(MovieScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
        composable(
            MovieScreens.DetailsScreen.name + "/{move}",
            arguments = listOf(navArgument(name = "move") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            DetailsScreen(
                navController = navController,
                backStackEntry.arguments?.getString("move")
            )
        }
    }
}