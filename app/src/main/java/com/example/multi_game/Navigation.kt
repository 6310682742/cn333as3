package com.example.multi_game

import HomeScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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