package com.example.multi_game.guessMyBirthDayGame.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.multi_game.guessMyBirthDayGame.data.QuestionDataList

class GuessMyBirthdayViewModel:ViewModel() {
    private val _state = mutableStateOf(0)
    val state = _state
    private val _birthDay = mutableStateOf(0)
    private val _count = mutableStateOf(-1)
    val count = _count
    private val _message = mutableStateOf("")
    val message = _message
    private val _dayList = mutableStateOf(QuestionDataList().questionList[0].day)
    val dayList = _dayList
    fun listContainsBirthDay():Boolean {
        return _dayList.value.contains(_birthDay.value)
    }
    fun startGame() {
        _state.value = 1
        _birthDay.value =generateBirthDay()
        _count.value = -1
        _message.value = ""
    }
    fun checkAns(ans:String) {
        if(ans == "") return
        _count.value++
        _dayList.value = QuestionDataList().questionList[(_count.value+1)%QuestionDataList().questionList.size].day
        val ansInt = ans.toInt()
        if(ansInt == _birthDay.value) {
            _state.value = 0
            _message.value = "You have try ${_count.value} times to get correct my birth day"
            return
        }
    }
    private fun generateBirthDay(): Int {
        return (1..31).random()
    }
}