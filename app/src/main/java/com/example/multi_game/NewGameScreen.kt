package com.example.multi_game

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun NewGameScreen(navController: NavController) {
    Column() {
        Text(text = "This is NewGameScreen")
        Button(onClick = {
            navController.navigate(Screen.HomeScreen.route)
        }) {
            Text(text = "Back to Home Page")
        }
    }
}