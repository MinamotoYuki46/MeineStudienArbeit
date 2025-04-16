package com.example.diceroller

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.appcompat.app.AppCompatActivity
import com.example.diceroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding :ActivityMainBinding
    private val viewModel : DiceRollerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRoll.setOnClickListener {
            viewModel.rollDice()
        }

        viewModel.diceLeft.observe(this, Observer {
            value -> binding.imgvDiceLeft.setImageResource(getDiceImage(value))
        })

        viewModel.diceRight.observe(this, Observer {
            value -> binding.imgvDiceRight.setImageResource(getDiceImage(value))
        })

        viewModel.isDouble.observe(this, Observer {
            isDouble -> Toast.makeText(this, viewModel.getMessage(), Toast.LENGTH_SHORT).show()
        })
    }

    private fun getDiceImage(value: Int): Int{
        return when(value) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_0
        }
    }
}