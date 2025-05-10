package com.example.treblewinner.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.treblewinner.screen.clubdetails.ClubDetailScreen
import com.example.treblewinner.screen.clublist.ClubListScreen
import com.example.treblewinner.screen.ClubViewModel

@Composable
fun AppNavHost(navController: NavHostController) {

    val clubVM: ClubViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "club_list"
    ) {
        composable("club_list") {
            ClubListScreen(navController = navController, viewModel = clubVM)
        }

        composable("club_detail") {
            if (clubVM.selectedClub != null) {
                ClubDetailScreen(navController = navController, clubVM = clubVM)
            } else {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("No club selected")
                }
            }
        }
    }
}