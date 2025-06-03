package com.example.treblewinner.presentation.clubdetails

import android.content.Context
import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.treblewinner.domain.model.Club
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.treblewinner.domain.model.Competition
import androidx.compose.runtime.getValue



@Composable
fun ClubDetailsScreen(
    clubId: String,
    onBack: () -> Unit,
    viewModel: ClubDetailsViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(clubId) {
        viewModel.loadClubDetail(clubId)
    }

    when {
        uiState.isLoading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        uiState.error != null -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Error: ${uiState.error}")
            }
        }
        uiState.club != null -> {
            val club = uiState.club
            val competitions = uiState.competitions
            ClubDetailContent(
                club,
                competitions,
                onBack,
                onToggleBookmark = { viewModel.toggleBookmark()}
            )
        }
    }
}



fun Context.isDarkTheme(): Boolean {
    return (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun ClubDetailContent(
    club: Club?,
    competitions: List<Competition>,
    onBack: () -> Unit,
    onToggleBookmark: () -> Unit
) {
    Log.i("ClubDetailScreen", "Club is loaded...")
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = club?.name ?: "") },
                navigationIcon = {
                    IconButton(onClick = {
                        Log.i("ClubDetailScreen", "User click back button to the ClubListScreen")
                        onBack()
                    }) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = onToggleBookmark) {
                        Icon(
                            imageVector = if (club?.isBookmarked == true) Icons.Filled.Star else Icons.Outlined.Star,
                            contentDescription = if (club?.isBookmarked == true) "Unbookmark" else "Bookmark",
                            tint = if (club?.isBookmarked == true) Color(0xFFFFD700) else LocalContentColor.current
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
                .padding(padding)
        ) {
            GlideImage(
                model = club?.logoUrl,
                contentDescription = "${club?.name} logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Fit
            )
            Log.i("ClubDetailScreen", "Club logo is loaded")

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = club?.name ?: "",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Log.i("ClubDetailScreen", "Club name is loaded")

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = club?.country ?:"", style = MaterialTheme.typography.bodyLarge)
                Log.i("ClubDetailScreen", "Club country is loaded")
                Text(text = "•", style = MaterialTheme.typography.bodyLarge)
                Text(text = club?.confederation ?:"", style = MaterialTheme.typography.bodyLarge)
                Log.i("ClubDetailScreen", "Club confederation is loaded")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Treble Years:",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
            ){
                club?.trebleYears?.forEach { year ->
                    YearTagOutlined(year)
                }
            }


            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Competitions Won:",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
            ) {
                competitions.forEach { competition ->
                    CompetitionCard(competition = competition)
                }
            }


            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "About:",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = club?.description ?:"",
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.bodyMedium
            )
            Log.i("ClubDetailScreen", "Club description is loaded")
        }
    }
}

@Composable
fun YearTagOutlined(year: String) {
    val tagColor = Color(0xFFD2B571)
    Surface(
        shape = RoundedCornerShape(50),
        border = BorderStroke(2.dp, tagColor),
        color = Color.Transparent,
        tonalElevation = 1.dp // Optional
    ) {
        Text(
            text = year,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
            fontSize = 12.sp,
            color = tagColor
        )
    }
    Log.i("ClubDetailScreen", "Club treble year is loaded")
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CompetitionCard(competition: Competition) {
    val context = LocalContext.current
    val logo = if (context.isDarkTheme() && competition.logoUrlDark.isNotBlank()) {
        competition.logoUrlDark
    } else {
        competition.logoUrl
    }

    LaunchedEffect(competition) {
        Log.i("ClubDetailScreen", "Competition ${competition.name} loaded logo ${if (context.isDarkTheme()) "dark" else "normal"}")
    }

    Card(
        modifier = Modifier
            .width(100.dp)
            .height(200.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            GlideImage(
                model = logo,
                contentDescription = competition.name,
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Fit
            )

            Text(
                text = competition.name,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center
            )
            Log.i("ClubDetailScreen", "Competition name is loaded")
        }
    }
}
