package com.example.multi_game.quizGame.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.multi_game.quizGame.data.QuestionList
import com.example.multi_game.quizGame.dataModel.Question

class QuizGameViewModel:ViewModel() {
    private val _state = mutableStateOf(0)
    val state = _state
    private val _quiz = mutableStateOf(Question())
    val quiz = _quiz
    private val _usedQuiz = mutableSetOf<Question>()
    private val _score = mutableStateOf(0)
    val score = _score
    private val _quizNumber = mutableStateOf(0)
    private val _message = mutableStateOf("")
    val message = _message
    private val _no = mutableStateOf(0)
    val no = _no
    private fun generateQuiz(questionList: QuestionList = QuestionList()): Question {
        val remain:Question = questionList.questionList.filterNot { it in _usedQuiz }.random()
        _usedQuiz.add(remain)
        _quizNumber.value++
        _quiz.value = remain
        return remain
    }
    fun startGame() {
        _state.value = 1
        _score.value = 0
        _no.value = 0
        _usedQuiz.clear()
        _quizNumber.value = 1
        _message.value = ""
        generateQuiz()
    }
    fun checkAnswer(ans:String) {
        _no.value++
        if(_quiz.value.correctAnswer == ans) {
            _score.value++
        }
        if(_usedQuiz.size == 10) {
            _state.value = 0
            _message.value = "You have ${_score.value}/10 score"
        }
        else {
            generateQuiz()
        }
    }
}