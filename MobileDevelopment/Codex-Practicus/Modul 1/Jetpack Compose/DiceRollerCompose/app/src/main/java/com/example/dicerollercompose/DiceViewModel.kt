package com.example.dicerollercompose

import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class DiceViewModel: ViewModel(){
    var numDiceLeft by mutableStateOf(0)
        private set

    var numDiceRight by mutableStateOf(0)
        private set

    fun rollDice() {
        numDiceLeft = (1..6).random()
        numDiceRight = (1..6).random()
    }

    fun getResultMessage(): String {
        return if (numDiceLeft == numDiceRight)
            "Selamat, Anda mendapatkan nilai double"
        else
            "Maaf, Anda belum beruntung"
    }
}