package com.example.multi_game.quizGame.dataModel

data class Question(
    val question: String="",
    val answerList: List<String> = listOf(),
    val correctAnswer:String = ""
)