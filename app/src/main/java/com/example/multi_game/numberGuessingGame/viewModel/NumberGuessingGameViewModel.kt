package com.example.multi_game.numberGuessingGame.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class NumberGuessingGameViewModel: ViewModel() {
    private val _state = mutableStateOf(0)
    private val _myNumber = mutableStateOf(0)
    val state = _state
    private val _result = mutableStateOf(0)
    private val _hint = mutableStateOf("")
    val hint = _hint
    private val _count = mutableStateOf(-1)
    fun onGameStart() {
        _state.value = 1
        _hint.value = ""
        _count.value = -1
        generateMyNumber()
    }
    private fun generateMyNumber() {
        _myNumber.value = (1..1000).random()
    }
    fun checkAnswer(answer:String){
        if(answer == "")return
        val ans=answer.toInt()
        _count.value++
        if(ans == _myNumber.value) {
            _state.value = 0
            _hint.value = "You have try ${_count.value} times"
            return
        }
        _result.value = ans - _myNumber.value
        if(_result.value > 0) {
            _hint.value = "Hint: It's lower!"
        }
        else {
            _hint.value = "Hint: It's higher!"
        }

    }
}