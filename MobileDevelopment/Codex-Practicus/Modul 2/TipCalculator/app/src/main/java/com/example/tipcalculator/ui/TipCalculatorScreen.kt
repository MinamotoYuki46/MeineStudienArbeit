package com.example.tipcalculator.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tipcalculator.ui.components.*
import com.example.tipcalculator.viewmodel.TipCalculatorViewModel
import androidx.compose.ui.text.font.*
import java.text.DecimalFormat
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipCalculatorScreen(viewModel: TipCalculatorViewModel = viewModel()) {
    val bill by viewModel.billAmt.collectAsState()
    val rating by viewModel.rating.collectAsState()
    val tip by viewModel.tipAmt.collectAsState()
    val roundUp by viewModel.roundUp.collectAsState()

    val ratingOptions = listOf("Okay (15%)", "Good (18%)", "Amazing (20%)")

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Tip Calculator")
                }
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(padding)
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                BillInputField(
                    value = bill,
                    onValueChange = viewModel::onBillChanged
                )

                TipRating(
                    selectedRating = rating,
                    options = ratingOptions,
                    onRatingSelected = viewModel::onRatingSelected
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Round Up Tip?")
                    Switch(
                        checked = roundUp,
                        onCheckedChange = viewModel::onRoundUpChanged
                    )
                }

                Button(
                    onClick = viewModel::calculateTip,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Calculate")
                }
                val formattedTip = formatAsCurrency(tip)

                Text(
                    text = "Tip: \nRp$formattedTip",
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
                )
            }
        }
    )
}

fun formatAsCurrency(amount: Float): String {
    val formatter = DecimalFormat("#,###.00")
    return formatter.format(amount)
}

@Preview(showBackground = true)
@Composable
fun TipCalculatorScreenPreview() {
    val fakeViewModel = TipCalculatorViewModel()
    fakeViewModel.onBillChanged("100")
    fakeViewModel.onRatingSelected("Amazing")

    TipCalculatorScreen(viewModel = fakeViewModel)
}
