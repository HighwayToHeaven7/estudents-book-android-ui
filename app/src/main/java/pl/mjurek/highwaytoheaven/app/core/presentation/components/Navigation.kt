package pl.mjurek.highwaytoheaven.app.core.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pl.mjurek.highwaytoheaven.app.core.util.Screen
import pl.mjurek.highwaytoheaven.app.feature_auth.presentation.login.LoginScreen
import pl.mjurek.highwaytoheaven.app.feature_auth.presentation.splash.SplashScreen
import pl.mjurek.highwaytoheaven.app.feature_home.domain.fake.getFakeNotification
import pl.mjurek.highwaytoheaven.app.feature_home.presentation.HomeScreen
import pl.mjurek.highwaytoheaven.app.feature_home.presentation.grades.GradesScreen
import pl.mjurek.highwaytoheaven.app.feature_home.presentation.user_data.UserDataScreen
import pl.mjurek.highwaytoheaven.app.feature_notifications.presentation.notifications.NotificationsScreen


@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun Navigation(
    navController: NavHostController,
    scaffoldState: ScaffoldState
) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(Screen.Login.route) {
            LoginScreen(
                onNavigate = navController::navigate,
                onLogin = {
                    navController.popBackStack(
                        route = Screen.Login.route,
                        inclusive = true
                    )
                    navController.navigate(route = Screen.Home.route)
                },
                scaffoldState = scaffoldState
            )
        }
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.Notifications.route) {
            NotificationsScreen(getFakeNotification())
        }
//        composable(Screen.Settings.route) {
//            SettingsScreen()
//        }
        composable(Screen.Grades.route) {
            GradesScreen()
        }
        composable(Screen.UserDetail.route) {
            UserDataScreen()
        }
    }
}

