package com.example.diceroller

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class DiceRollerViewModel: ViewModel() {
    private val _diceLeft = MutableLiveData(1)
    val diceLeft : LiveData<Int>
        get() = _diceLeft

    private val _diceRight = MutableLiveData(1)
    val diceRight: LiveData<Int>
        get() = _diceRight

    private val _isDouble = MutableLiveData(false)
    val isDouble : LiveData<Boolean>
        get() = _isDouble

    fun rollDice() {
        _diceLeft.value = (1..6).random()
        _diceRight.value = (1..6).random()

        _isDouble.value = _diceLeft.value == _diceRight.value
    }

    fun getMessage(): String {
        return if (_isDouble.value == true) {
            "Selamat, Anda dapat dadu double!"
        } else {
            "Anda belum beruntung!"
        }
    }
}