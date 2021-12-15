package pl.mjurek.highwaytoheaven.app.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pl.mjurek.highwaytoheaven.app.presentation.notifications.NotificationsScreen
import pl.mjurek.highwaytoheaven.app.presentation.home.HomeScreen
import pl.mjurek.highwaytoheaven.app.presentation.settings.SettingsScreen
import pl.mjurek.highwaytoheaven.app.domain.notification.getFakeNotification

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable("notifications") {
            NotificationsScreen(getFakeNotification())
        }
        composable("settings") {
            SettingsScreen()
        }
    }
}
