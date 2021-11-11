package pl.mjurek.highwaytoheaven.app

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pl.mjurek.highwaytoheaven.app.composable.chat.ChatScreen
import pl.mjurek.highwaytoheaven.app.composable.home.HomeScreen
import pl.mjurek.highwaytoheaven.app.composable.settings.SettingsScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("chat") {
            ChatScreen()
        }
        composable("settings") {
            SettingsScreen()
        }
    }
}
