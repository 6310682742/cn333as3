package com.example.multi_game

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.multi_game.NumberGuessingGame.viewModel.NumberGuessingGameViewModel
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun NumberGuessingGameScreen(navController: NavController, viewModels:NumberGuessingGameViewModel = NumberGuessingGameViewModel()) {
    val state = viewModels.state
    val myNumber = viewModels.myNumber
    var guessNumber = ""
    
    Column() {
        Text(text = "Number Guessing Game")
        Text(text = "Try to guess the number I'm thinking of from 1-1000!")
        TextField(value = guessNumber, onValueChange = {
            newNumber ->
            guessNumber = newNumber
        },
            label = { Text(text = "Guess Number") },
            placeholder = { Text(text = "Enter Guess Number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )
        Button(onClick = {
            viewModels.checkAnswer(guessNumber.toInt())
        }) {
            Text(text = "Play Again!")
        }
        Button(onClick = { 
            navController.navigate(Screen.HomeScreen.route) 
        }) {
            Text(text = "Back to Home Page")
        }
    }
}