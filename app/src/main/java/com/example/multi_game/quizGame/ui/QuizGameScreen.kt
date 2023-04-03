package com.example.multi_game.quizGame.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.multi_game.Screen
import com.example.multi_game.quizGame.viewModel.QuizGameViewModel

@Composable
fun QuizGameScreen(navController: NavController, viewModels: QuizGameViewModel = QuizGameViewModel()) {

    Surface {
        Column {
            Text(text = "This is QuizGameScreen")
            Text(text = viewModels.message.value)
            if(viewModels.state.value == 0){
                Button(onClick = { viewModels.startGame() }) {
                    Text(text = "Start Game!")
                }
            }
            else {
                Text(text = viewModels.quiz.value.question)
                for(ans in viewModels.quiz.value.answerList.shuffled()) {
                    Button(onClick = { viewModels.checkAnswer(ans) }) {
                        Text(text = ans)
                    }
                }
            }
            Button(onClick = {
                navController.navigate(Screen.HomeScreen.route)
            }) {
                Text(text = "Back to Home Page")
            }
        }
    }

}