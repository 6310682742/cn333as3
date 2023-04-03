package com.example.multi_game.quizGame.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.multi_game.Screen
import com.example.multi_game.quizGame.viewModel.QuizGameViewModel
import com.example.multi_game.ui.theme.Purple500

@Composable
fun QuizGameScreen(
    navController: NavController, viewModels: QuizGameViewModel = QuizGameViewModel()
) {

    Surface {

        Column {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Purple500)
                    .height(60.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Quiz Game",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(6.dp),
                    color = Color.White
                )
                Text(
                    text = "${viewModels.no.value} of 10 questions",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(6.dp),
                    color = Color.White
                )
                Text(
                    text = "Score: ${viewModels.score.value}",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(6.dp),
                    color = Color.White
                )
            }
            if (viewModels.state.value == 0) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = viewModels.message.value, fontSize = 20.sp)
                }
            }

            if (viewModels.state.value == 0) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(onClick = { viewModels.startGame() }) {

                        Text(text = "Start Game!")

                    }
                }

            } else {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp),
                ) {
                    Text(text = viewModels.quiz.value.question, modifier = Modifier.fillMaxWidth())

                }
                for (ans in viewModels.quiz.value.answerList.shuffled()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(6.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(onClick = { viewModels.checkAnswer(ans) }) {
                            Text(
                                text = ans,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }

                    }

                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = {
                    navController.navigate(Screen.HomeScreen.route)
                }) {
                    Text(text = "Back to Home Page")
                }
            }

        }
    }
}