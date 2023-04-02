import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.example.multi_game.Screen

@Composable
fun HomeScreen(navController: NavController) {
    Column() {
        Text(text = "This is Home Page")
        Button(onClick = {
            navController.navigate(Screen.NumberGuessingGameScreen.route)
        }) {
            Text(text = "Number Guessing Game")
        }
        Button(onClick = {
            navController.navigate(Screen.QuizGameScreen.route)
        }) {
            Text(text = "Quiz Game")
        }
        Button(onClick = {
            navController.navigate(Screen.NewGameScreen.route)
        }) {
            Text(text = "New Game")
        }
    }
}