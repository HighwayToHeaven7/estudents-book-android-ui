package pl.mjurek.highwaytoheaven.app.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pl.mjurek.highwaytoheaven.app.presentation.notifications.NotificationsScreen
import pl.mjurek.highwaytoheaven.app.presentation.home.HomeScreen
import pl.mjurek.highwaytoheaven.app.presentation.settings.SettingsScreen
import pl.mjurek.highwaytoheaven.app.domain.notification.getFakeNotification
import pl.mjurek.highwaytoheaven.app.presentation.home.UserAction
import pl.mjurek.highwaytoheaven.app.presentation.home.grades.Grades
import pl.mjurek.highwaytoheaven.app.presentation.home.time_table.TimeTable


sealed class DrawerScreens(val title: String) {
    object Home : DrawerScreens("home")
    object Notifications : DrawerScreens("notifications")
    object Settings : DrawerScreens("settings")
    object Grades : DrawerScreens("grades")
    object TimeTable : DrawerScreens("time_table")
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = DrawerScreens.Home.title) {
        composable(DrawerScreens.Home.title) {
            HomeScreen(navController, userActions())
        }
        composable(DrawerScreens.Notifications.title) {
            NotificationsScreen(getFakeNotification())
        }
        composable(DrawerScreens.Settings.title) {
            SettingsScreen()
        }
        composable(DrawerScreens.Grades.title) {
            Grades()
        }
        composable(DrawerScreens.TimeTable.title) {
            TimeTable()
        }
    }
}

fun userActions(): List<UserAction> {
    return listOf(
        UserAction(
            name = "Oceny",
            navigation = DrawerScreens.Grades.title
        ),
        UserAction(
            name = "Plan zajec",
            navigation = DrawerScreens.TimeTable.title
        )
    )
}
