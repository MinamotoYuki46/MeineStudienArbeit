package com.example.tipcalculator.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.math.ceil

class TipCalculatorViewModel: ViewModel() {
    private val _billAmt = MutableStateFlow("")
    val billAmt: StateFlow<String> = _billAmt

    private val _rating = MutableStateFlow("Okay")
    val rating: StateFlow<String> = _rating

    private val _tipAmt = MutableStateFlow(0f)
    val tipAmt: StateFlow<Float> = _tipAmt

    private val _roundUp = MutableStateFlow(false)
    val roundUp: StateFlow<Boolean> = _roundUp

    fun onBillChanged(newAmt: String){
        _billAmt.value = newAmt
    }

    fun onRatingSelected(newRating: String){
        _rating.value = newRating
    }

    fun onRoundUpChanged(newValue: Boolean) {
        _roundUp.value = newValue
    }

    fun calculateTip() {
        val bill = _billAmt.value.replace(",", "").toDoubleOrNull() ?: 0.0
        val percentage = when (_rating.value) {
            "Okay (15%)" -> 15.0
            "Good (18%)" -> 18.0
            "Amazing (20%)" -> 20.0
            else -> 0.0
        }
        val tip = bill * percentage / 100.0
        _tipAmt.value = if (_roundUp.value) ceil(tip).toFloat() else tip.toFloat()
    }
}