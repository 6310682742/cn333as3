package com.example.multi_game.numberGuessingGame.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.multi_game.Screen
import com.example.multi_game.numberGuessingGame.viewModel.NumberGuessingGameViewModel
import com.example.multi_game.ui.theme.Purple500

@Composable
fun NumberGuessingGameScreen(navController: NavController, viewModels:NumberGuessingGameViewModel = NumberGuessingGameViewModel()) {
    var guessNumber by remember {
        mutableStateOf("")
    }
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
                Text(text = "Number Guessing Game", fontSize = 20.sp, modifier = Modifier.padding(16.dp), color = Color.White)
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Try to guess the number I'm thinking of from 1-1000!", modifier = Modifier
                    .padding(26.dp)
                    .fillMaxWidth()
                    , textAlign = TextAlign.Center, fontSize = 20.sp)
            }

//            Text(text = "result: ${viewModels.result.value}")
//            Text(text = "MyNumber: ${viewModels.myNumber.value}")
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                Text(text = viewModels.hint.value)
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                if(viewModels.state.value == 1)
                    TextField(value = guessNumber, onValueChange = {text -> guessNumber = text}, label = { Text(text = "Guess Number") }, placeholder = { Text(text = "Enter Your Guess Number") },keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                    ),)

            }
//            Text(text = "State: ${viewModels.state.value}")
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                if(viewModels.state.value == 0) {
                    Button(onClick = { viewModels.onGameStart() }) {
                        Text(text = "StartGame")
                    }
                }
                else {
                    Button(onClick = {
                        viewModels.checkAnswer(guessNumber)
                        guessNumber = ""
                    }) {
                        Text(text = "Guess!")
                    }
                }


            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                Button(onClick = {
                    navController.navigate(Screen.HomeScreen.route)
                }) {
                    Text(text = "Back to Home Page")
                }
            }

        }
    }

}