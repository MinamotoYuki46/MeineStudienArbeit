package com.example.treblewinner.presentation.home

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.treblewinner.presentation.clublist.ClubListScreen
import com.example.treblewinner.presentation.bookmark.BookmarkedClubsScreen
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToDetail: (clubId: String) -> Unit,
) {
    val tabs = listOf(
        NavTab("All Clubs", Icons.AutoMirrored.Filled.List),
        NavTab("Bookmarks", Icons.Default.Star)
    )

    val pagerState = rememberPagerState(pageCount = { tabs.size })
    var selectedTabIndex by rememberSaveable { mutableIntStateOf(0)}
    val scope = rememberCoroutineScope()

    val scrollStates = remember {
        List(tabs.size) { LazyListState() }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Treble Winner Clubs") }
            )
        },
        bottomBar = {
            NavigationBar {
                tabs.forEachIndexed { index, tab ->
                    NavigationBarItem(
                        icon = { Icon(tab.icon, contentDescription = tab.title) },
                        label = { Text(tab.title) },
                        selected = selectedTabIndex == index,
                        onClick = {
                            selectedTabIndex = index

                            scope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.padding(innerPadding),
            userScrollEnabled = true,
        ) { page ->
            when (page) {
                0 -> ClubListScreen(
                    onNavigateToDetail = onNavigateToDetail,
                    lazyListState = scrollStates[0]
                )
                1 -> BookmarkedClubsScreen(
                    onNavigateToDetail = onNavigateToDetail,
                    lazyListState = scrollStates[1]
                )
            }
        }

        LaunchedEffect(pagerState.currentPage) {
            selectedTabIndex = pagerState.currentPage
        }
    }
}

data class NavTab(val title: String, val icon: ImageVector)

