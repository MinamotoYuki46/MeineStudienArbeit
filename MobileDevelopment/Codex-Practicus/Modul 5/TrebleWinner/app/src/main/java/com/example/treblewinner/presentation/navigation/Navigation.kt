package com.example.treblewinner.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.treblewinner.presentation.home.HomeScreen
import com.example.treblewinner.presentation.clubdetails.ClubDetailsScreen
import com.example.treblewinner.presentation.clublist.ClubListScreen

sealed class Screen(val route: String) {
    object Main : Screen("main")
    object List : Screen("club_list")
    object Detail : Screen("detail/{clubId}") {
        fun createRoute(clubId: String) = "detail/$clubId"
    }
}

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Main.route
    ){
        composable(Screen.Main.route){
            HomeScreen(
                onNavigateToDetail = { clubId ->
                    navController.navigate(Screen.Detail.createRoute(clubId))
                }
            )
        }

        composable(Screen.List.route) {
            ClubListScreen(
                onNavigateToDetail = { clubId ->
                    navController.navigate(Screen.Detail.createRoute(clubId))
                }
            )
        }

        composable(Screen.Detail.route) { backStackEntry ->
            val clubId = backStackEntry.arguments?.getString("clubId") ?: ""
            ClubDetailsScreen(
                clubId = clubId,
                onBack = { navController.popBackStack() }
            )
        }
    }
}