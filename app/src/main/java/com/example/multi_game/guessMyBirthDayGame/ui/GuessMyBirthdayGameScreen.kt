package com.example.multi_game.guessMyBirthDayGame.ui

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.multi_game.Screen
import com.example.multi_game.guessMyBirthDayGame.viewModel.GuessMyBirthdayViewModel
import com.example.multi_game.ui.theme.Purple500

@Composable
fun GuessMyBirthdayGame(navController: NavController, viewModel: GuessMyBirthdayViewModel = GuessMyBirthdayViewModel()) {
    var guessBirthday by remember {
        mutableStateOf("")
    }
    Surface {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Purple500)
                    .height(60.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Guess My Birthday",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(16.dp),
                    color = Color.White
                )
            }
//            Text(text = viewModel.count.value.toString())
            Row(modifier = Modifier.fillMaxWidth().padding(6.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                Text(text = viewModel.message.value, modifier = Modifier.fillMaxWidth())
            }
            if(viewModel.state.value == 1) {
                Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                    viewModel.dayList.value.subList(0, 4).forEach {
                        Text(text = it.toString(), modifier = Modifier.padding(6.dp))
                    }
                }
                Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                    viewModel.dayList.value.subList(4, 8).forEach {
                        Text(text = it.toString(), modifier = Modifier.padding(6.dp))
                    }
                }
                Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                    viewModel.dayList.value.subList(8, 12).forEach {
                        Text(text = it.toString(), modifier = Modifier.padding(6.dp))
                    }
                }
                Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                    viewModel.dayList.value.subList(12, 16).forEach {
                        Text(text = it.toString(), modifier = Modifier.padding(6.dp))
                    }
                }
                Row(modifier = Modifier.fillMaxWidth().padding(6.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                    if (viewModel.listContainsBirthDay()) {
                        Text(text = "My birthday is in this list")
                    } else {
                        Text(text = "My birthday is not in this list")
                    }
                }

            }
//            for (day in viewModel.dayList.value) {
//                Text(text = day.toString())
//            }
            if(viewModel.state.value == 0) {
                Row(modifier = Modifier.fillMaxWidth().padding(6.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                    Button(onClick = { viewModel.startGame() }) {
                        Text(text = "Start Game!")
                    }
                }

            }
            else {
                Row(modifier = Modifier.fillMaxWidth().padding(6.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically)
                    {
                        TextField(value = guessBirthday, onValueChange = {
                                text -> guessBirthday = text
                        },label = { Text(text = "Guess Birthday") }, placeholder = { Text(text = "Enter Your Guess Birthday") },keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                        ),)
                    }

                Row(modifier = Modifier.fillMaxWidth().padding(6.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                    Button(onClick = { viewModel.checkAns(guessBirthday) }) {
                        Text(text = "Guess")
                    }
                }

            }
            Row(modifier = Modifier.fillMaxWidth().padding(6.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                Button(onClick = {
                    navController.navigate(Screen.HomeScreen.route)
                }) {
                    Text(text = "Back to Home Page")
                }
            }
        }
    }

}