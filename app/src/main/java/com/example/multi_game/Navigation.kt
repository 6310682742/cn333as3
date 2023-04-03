package com.example.multi_game

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.multi_game.numberGuessingGame.ui.NumberGuessingGameScreen
import com.example.multi_game.quizGame.ui.QuizGameScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.NumberGuessingGameScreen.route) {
            NumberGuessingGameScreen(navController = navController)
        }
        composable(route = Screen.QuizGameScreen.route) {
            QuizGameScreen(navController = navController)
        }
        composable(route = Screen.NewGameScreen.route) {
            NewGameScreen(navController = navController)
        }
    }
}