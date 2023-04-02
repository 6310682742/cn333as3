import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.multi_game.Screen

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Multi-Game", modifier = Modifier.padding(20.dp), fontSize = 25.sp )
        Button(onClick = {
            navController.navigate(Screen.NumberGuessingGameScreen.route)
        },
        modifier = Modifier.fillMaxWidth()) {
            Text(text = "Number Guessing Game")
        }
        Button(onClick = {
            navController.navigate(Screen.QuizGameScreen.route)
        },
        modifier = Modifier.fillMaxWidth()) {
            Text(text = "Quiz Game")
        }
        Button(onClick = {
            navController.navigate(Screen.NewGameScreen.route)
        },
        modifier = Modifier.fillMaxWidth()) {
            Text(text = "New Game")
        }
    }
}