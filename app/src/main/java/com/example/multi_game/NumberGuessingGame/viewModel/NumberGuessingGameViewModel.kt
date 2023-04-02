package com.example.multi_game.NumberGuessingGame.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class NumberGuessingGameViewModel: ViewModel() {
    private val _state = mutableStateOf(0)
    private val _myNumber = mutableStateOf(0)
    val state = _state
    val myNumber = _myNumber
    fun onGameStart() {
        _state.value = 1
        generateMyNumber()
    }
    private fun generateMyNumber() {
        _myNumber.value = (1..1000).random()
    }
    fun checkAnswer(answer:Int): Int {
        if(answer == _myNumber.value) {
            _state.value = 0
            return 0
        }
        return answer - _myNumber.value
    }
}