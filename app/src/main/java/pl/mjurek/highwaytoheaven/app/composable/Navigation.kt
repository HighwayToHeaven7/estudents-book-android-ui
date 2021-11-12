package pl.mjurek.highwaytoheaven.app.composable

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pl.mjurek.highwaytoheaven.app.composable.notifications.NotificationsScreen
import pl.mjurek.highwaytoheaven.app.composable.home.HomeScreen
import pl.mjurek.highwaytoheaven.app.composable.settings.SettingsScreen
import pl.mjurek.highwaytoheaven.app.domain.notification.getFakeNotification

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("notifications") {
            NotificationsScreen(getFakeNotification())
        }
        composable("settings") {
            SettingsScreen()
        }
    }
}
