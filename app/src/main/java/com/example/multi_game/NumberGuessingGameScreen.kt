package com.example.multi_game

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun NumberGuessingGameScreen(navController: NavController) {
    Column() {
        Text(text = "This is Number Guessing Game Screen")
        Button(onClick = { 
            navController.navigate(Screen.HomeScreen.route) 
        }) {
            Text(text = "Back to Home Page")
        }
    }
}