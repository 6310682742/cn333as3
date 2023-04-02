package com.example.multi_game

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun QuizGameScreen(navController: NavController) {
    Column() {
        Text(text = "This is QuizGameScreen")
        Button(onClick = {
            navController.navigate(Screen.HomeScreen.route)
        }) {
            Text(text = "Back to Home Page")
        }
    }
}