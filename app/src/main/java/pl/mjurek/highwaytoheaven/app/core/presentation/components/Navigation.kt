package pl.mjurek.highwaytoheaven.app.core.presentation.utils

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pl.mjurek.highwaytoheaven.app.core.util.Screen
import pl.mjurek.highwaytoheaven.app.domain.fake.getFakeGrades
import pl.mjurek.highwaytoheaven.app.domain.fake.getFakeNotification
import pl.mjurek.highwaytoheaven.app.feature_auth.presentation.login.LoginScreen
import pl.mjurek.highwaytoheaven.app.feature_auth.presentation.splash.SplashScreen
import pl.mjurek.highwaytoheaven.app.presentation.home.HomeScreen
import pl.mjurek.highwaytoheaven.app.presentation.home.UserAction
import pl.mjurek.highwaytoheaven.app.presentation.home.grades.GradesScreen
import pl.mjurek.highwaytoheaven.app.presentation.home.time_table.TimeTable
import pl.mjurek.highwaytoheaven.app.presentation.notifications.NotificationsScreen
import pl.mjurek.highwaytoheaven.app.presentation.settings.SettingsScreen


@ExperimentalFoundationApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(Screen.Login.route) {
            LoginScreen(navController)
        }
        composable(Screen.Home.route) {
            HomeScreen(navController, userActions())
        }
        composable(Screen.Notifications.route) {
            NotificationsScreen(getFakeNotification())
        }
        composable(Screen.Settings.route) {
            SettingsScreen()
        }
        composable(Screen.Grades.route) {
            GradesScreen(getFakeGrades())
        }
        composable(Screen.SchoolActivities.route) {
            TimeTable()
        }
    }
}

fun userActions(): List<UserAction> {
    return listOf(
        UserAction(
            name = "Oceny",
            navigation = Screen.Grades.route
        ),
        UserAction(
            name = "Moje zajęcia",
            navigation = Screen.SchoolActivities.route
        )
    )
}
