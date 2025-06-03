package com.example.treblewinner.presentation.bookmark

import android.content.ActivityNotFoundException
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.treblewinner.domain.model.Club
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.net.toUri
import com.example.treblewinner.presentation.clublist.ClubCard

@Composable
fun BookmarkedClubsScreen(
    onNavigateToDetail: (String) -> Unit,
    lazyListState: LazyListState = rememberLazyListState(),
    viewModel: BookmarkedClubsViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val uiState by viewModel.uiState.collectAsState()

    var clubToUnbookmark by remember { mutableStateOf<Club?>(null) }
    var showConfirmDialog by remember { mutableStateOf(false) }

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
        else -> {
            LazyColumn(
                state = lazyListState,
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(uiState.bookmarkedClubs) { club ->
                    ClubCard(
                        club = club,
                        onDetailClick = {
                            Log.i("BookmarkedClubScreen", "User click the detail button for ${club.name}")
                            onNavigateToDetail(club.id)
                        },
                        onVisitClick = {
                            try {
                                val intent = Intent(Intent.ACTION_VIEW, club.webUrl.toUri())
                                context.startActivity(intent)
                                Log.d("BookmarkedClubScreen", "User going to the web ${club.name}")
                            } catch (e: ActivityNotFoundException) {
                                Log.e("BookmarkedClubScreen", "Browser not found", e)
                                Toast.makeText(context, "No browser available", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        },
                        onBookmarkClick = {
                            if (club.isBookmarked) {
                                clubToUnbookmark = club
                                showConfirmDialog = true
                            } else {
                                viewModel.toggleBookmark(club.id)
                            }
                        }
                    )
                }
            }
        }
    }

    if (showConfirmDialog && clubToUnbookmark != null) {
        AlertDialog(
            onDismissRequest = { showConfirmDialog = false },
            title = { Text("Remove Bookmark") },
            text = {
                Text("Are you sure you want to remove '${clubToUnbookmark!!.name}' from your bookmarks?")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        viewModel.toggleBookmark(clubToUnbookmark!!.id)
                        showConfirmDialog = false
                    }
                ) {
                    Text("Yes")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showConfirmDialog = false
                    }
                ) {
                    Text("No")
                }
            }
        )
    }
}
