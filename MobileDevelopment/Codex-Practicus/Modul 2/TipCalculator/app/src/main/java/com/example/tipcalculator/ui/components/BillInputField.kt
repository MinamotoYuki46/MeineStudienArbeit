package com.example.tipcalculator.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import java.text.DecimalFormat
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType


@Composable
fun BillInputField(value: String, onValueChange: (String) -> Unit) {
    var formattedValue by remember { mutableStateOf(value) }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),

        value = formattedValue,
        onValueChange = { newValue ->
            var cleaned = newValue.replace(Regex("[^\\d.]"), "")
            cleaned = cleaned.replace(Regex("\\.+"), ".")

            val parts = cleaned.split(".")
            val integerPart = parts.getOrElse(0) { "" }
            val decimalPart = parts.getOrElse(1) { "" }.take(2)

            val formattedInteger = try {
                when {
                    integerPart.isEmpty() && decimalPart.isNotEmpty() -> "0"
                    integerPart.isEmpty() -> ""
                    else -> DecimalFormat("#,###").format(integerPart.toLong())
                }
            } catch (e: NumberFormatException) {
                integerPart
            }

            val formatted = buildString {
                append(formattedInteger)
                if (decimalPart.isNotEmpty() || cleaned.endsWith(".")) {
                    append(".$decimalPart")
                }
            }

            formattedValue = formatted
            onValueChange(formatted)
        },
        label = { Text("Enter Bill Amount") },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions.Default,
        singleLine = true,
        textStyle = TextStyle.Default.copy(fontWeight = FontWeight.Bold)
    )
}
