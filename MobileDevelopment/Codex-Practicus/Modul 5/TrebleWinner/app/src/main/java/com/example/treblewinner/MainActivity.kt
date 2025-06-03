package com.example.treblewinner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.treblewinner.presentation.navigation.Navigation
import com.example.treblewinner.presentation.theme.TrebleWinnerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrebleWinnerTheme() {
                Navigation()
            }
        }
    }
}