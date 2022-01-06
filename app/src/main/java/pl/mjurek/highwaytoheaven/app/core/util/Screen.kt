package pl.mjurek.highwaytoheaven.app.core.util

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Login : Screen("login")
    object Home : Screen("home")
    object Notifications : Screen("notifications")
    object Settings : Screen("settings")
    object Grades : Screen("grades")
    object UserDetail : Screen("user_detail")
}