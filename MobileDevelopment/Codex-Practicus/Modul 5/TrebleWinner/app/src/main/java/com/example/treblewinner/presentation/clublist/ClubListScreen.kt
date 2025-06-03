package com.example.treblewinner.presentation.clublist

import android.content.ActivityNotFoundException
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.outlined.BookmarkAdd
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.treblewinner.domain.model.Club
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.net.toUri


@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun ClubListScreen(
    onNavigateToDetail: (String) -> Unit,
    lazyListState: LazyListState = rememberLazyListState(),
    viewModel: ClubListViewModel = hiltViewModel()
){
    val context = LocalContext.current
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadData()
    }


    when {
        uiState.isLoading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        uiState.error != null -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Error: ${uiState.error}")
            }
        }
        uiState.clubs.isEmpty() -> {
            Text("No clubs found")
        }
        else -> {
            LazyColumn(
                state = lazyListState,
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(uiState.clubs) { club ->
                    ClubCard(
                        club = club,
                        onDetailClick = {
                            Log.i("ClubListScreen", "User click the detail button for ${club.name}")
                            onNavigateToDetail(club.id)
                        },
                        onVisitClick = {
                            try {
                                val intent = Intent(Intent.ACTION_VIEW, club.webUrl.toUri())
                                context.startActivity(intent)
                                Log.d("ClubListScreen", "User going to the web ${club.name}")
                            } catch (e: ActivityNotFoundException) {
                                Log.e("ClubListScreen", "Browser not found", e)
                                Toast.makeText(context, "No browser available", Toast.LENGTH_SHORT).show()
                            }
                        },
                        onBookmarkClick = {
                            Log.i("ClubListScreen", "User toggled bookmark for ${club.name}")
                            viewModel.toggleBookmark(club.id)
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ClubCard(
    club: Club,
    onDetailClick: () -> Unit,
    onVisitClick: () -> Unit,
    onBookmarkClick: () -> Unit
) {
    LaunchedEffect(club.id) {
        Log.d("ClubCard", "Rendering ${club.name}, isBookmarked = ${club.isBookmarked}")
    }


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
                    .size(100.dp)
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
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(onClick = onDetailClick) {
                        Text("Details")
                    }
                    Button(onClick = onVisitClick) {
                        Text("Visit Site")
                    }
                    IconButton(onClick = {
                        Log.d("BookmarkToggle", "Toggle bookmark: ${club.name}, current: ${club.isBookmarked}")
                        onBookmarkClick()
                    }) {
                        Icon(
                            imageVector = if (club.isBookmarked == true) Icons.Filled.Bookmark else Icons.Outlined.BookmarkAdd,
                            contentDescription = null,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }
            }
        }
    }
}


val sampleClubs = listOf(
    Club(
        id = "fc_barcelona",
        name = "FC Barcelona",
        country = "Spain",
        confederation = "UEFA",
        trebleYears = listOf("2009", "2015"),
        competitionIds = listOf("la_liga", "copa_del_rey", "uefa_champions_league"),
        logoUrl = "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEh4xprb5TfHqTe6hCvl4hiV6pdlgPfiG_722ZGkfNOPbK1K7bWrklpdZ2wMR_qvSuCSpXuLKMSGAH7IhB9PY61vG5ctNQ4-R-Je18Uq5-oYEN8pfP0z7c7-EtQE_gjr-iDR2D3t6F26mr8/s16000/FC+Barcelona.png",
        webUrl = "https://www.fcbarcelona.com",
        description = "One of the greatest football clubs in the world.",
        isBookmarked = false
    ),
    Club(
        id = "manchester_united",
        name = "Manchester United",
        country = "England",
        confederation = "UEFA",
        trebleYears = listOf("1999"),
        competitionIds = listOf("premier_league", "fa_cup", "uefa_champions_league"),
        logoUrl = "https://upload.wikimedia.org/wikipedia/en/7/7a/Manchester_United_FC_crest.svg",
        webUrl = "https://www.manutd.com",
        description = "Legendary English football club based in Manchester.",
        isBookmarked = true
    ),
    Club(
        id = "bayern_munchen",
        name = "Bayern München",
        country = "Germany",
        confederation = "UEFA",
        trebleYears = listOf("2013"),
        competitionIds = listOf("bundesliga", "dfb_pokal", "uefa_champions_league"),
        logoUrl = "https://upload.wikimedia.org/wikipedia/en/1/1f/FC_Bayern_München_logo_%282017%29.svg",
        webUrl = "https://fcbayern.com",
        description = "The most successful club in German football history.",
        isBookmarked = false
    )
)


@Preview(
    name = "My Phone (1080x2400)",
    widthDp = 360,
    heightDp = 800,
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ClubListPreview0() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(sampleClubs) { club ->
            ClubCard(
                club = club,
                onDetailClick = { Log.d("Preview", "Detail clicked for ${club.name}") },
                onVisitClick = { Log.d("Preview", "Visit clicked for ${club.name}") },
                onBookmarkClick = { Log.d("Preview", "Bookmark toggled for ${club.name}") }
            )
        }
    }
}

@Preview(
    name = "Pixel 9 Pro XL (1344 x 2992)",
    widthDp = 448,
    heightDp = 998,
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ClubListPreview1() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(sampleClubs) { club ->
            ClubCard(
                club = club,
                onDetailClick = { Log.d("Preview", "Detail clicked for ${club.name}") },
                onVisitClick = { Log.d("Preview", "Visit clicked for ${club.name}") },
                onBookmarkClick = { Log.d("Preview", "Bookmark toggled for ${club.name}") }
            )
        }
    }
}