package edu.pbs.lab6_3_2.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import edu.pbs.lab6_3_2.MovieRow
import edu.pbs.lab6_3_2.navigation.MovieScreens

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.Magenta, elevation = 5.dp) {
                Text(text = "Movies")
            }
        },
    ) { it ->
        Column(
            modifier = Modifier.padding(it)
        ) {
            MainContent(navController = navController)
        }
    }
}

@Composable
fun MainContent(
    navController: NavController,
    moviesList: List<String> = listOf(
        "Avatar",
        "Harry Potter",
        "Lord of the Rings",
        "Star wars",
        "Batman",
        "Zorro",
        "Need for speed"
    )
) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = moviesList) {
                MovieRow(movie = it) { movie -> navController.navigate(route = MovieScreens.DetailsScreen.name + "/$movie") }
            }
        }
    }
}