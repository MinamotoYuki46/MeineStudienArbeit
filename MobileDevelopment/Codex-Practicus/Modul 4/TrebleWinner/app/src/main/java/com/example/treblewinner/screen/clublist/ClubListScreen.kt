package com.example.treblewinner.screen.clublist

import android.content.ActivityNotFoundException
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.treblewinner.model.Club
import com.example.treblewinner.screen.ClubViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun ClubListScreen(
    navController: NavController,
    clubVM: ClubViewModel
) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        clubVM.loadData()
        Log.d("ClubListScreen", "Club data loaded")
    }

    val clubs by clubVM.clubs.collectAsState(emptyList())

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Treble Winner Clubs List") }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(clubs) { club ->
                ClubCard(
                    club = club,
                    onDetailClick = {
                        Log.i("ClubListScreen", "User click the detail button for ${club.name}")
                        clubVM.selectClub(club)
                        navController.navigate("club_detail")
                    },
                    onVisitClick = {
                        try {
                            val intent = Intent(Intent.ACTION_VIEW, club.webUrl.toUri())
                            context.startActivity(intent)
                            Log.d("ClubListScreen", "User going to the web ${club.webUrl}")
                        } catch (e: ActivityNotFoundException) {
                            Log.e("ClubListScreen", "Browser not found", e)
                            Toast.makeText(context, "No browser available", Toast.LENGTH_SHORT).show()
                        }
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ClubCard(
    club: Club,
    onDetailClick: () -> Unit,
    onVisitClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            GlideImage(
                model = club.logoUrl,
                contentDescription = club.name,
                modifier = Modifier
                    .size(150.dp)
                    .aspectRatio(1f)
                    .padding(end = 8.dp)
            )

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = club.name,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = club.trebleYears.joinToString(", "),
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button(onClick = onDetailClick) {
                        Text("Details")
                    }
                    Button(onClick = onVisitClick) {
                        Text("Visit Site")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ClubListPreview() {
    val dummyViewModel = ClubViewModel(
        clubList = com.example.treblewinner.constants.ClubConstant.ALL
    )
    ClubListScreen(
        navController = rememberNavController(),
        clubVM = dummyViewModel
    )
}
