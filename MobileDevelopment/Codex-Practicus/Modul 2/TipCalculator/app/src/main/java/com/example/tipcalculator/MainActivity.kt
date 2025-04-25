package com.example.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tipcalculator.ui.TipCalculatorScreen
import com.example.tipcalculator.viewmodel.TipCalculatorViewModel
import com.example.tipcalculator.ui.theme.TipCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorTheme {
                val tipViewModel: TipCalculatorViewModel = viewModel()
                TipCalculatorScreen(viewModel = tipViewModel)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TipCalculatorPreview() {
    TipCalculatorTheme {
        val previewViewModel: TipCalculatorViewModel = viewModel()
        TipCalculatorScreen(viewModel = previewViewModel)
    }
}