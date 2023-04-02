package com.example.multi_game

sealed class Screen(val route:String) {
    object HomeScreen: Screen("main_screen")
    object NumberGuessingGameScreen: Screen("number_guessing_game_screen")
    object QuizGameScreen: Screen("quiz_game_screen")
    object NewGameScreen: Screen("new_game_screen")

    fun withArgs(vararg args:String): String {
        return buildString {
            append(route)
            args.forEach {
                    arg ->
                append("/$arg")
            }
        }
    }
}
