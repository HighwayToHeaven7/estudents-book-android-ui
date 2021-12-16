package pl.mjurek.highwaytoheaven.app.presentation.utils

sealed class Screen(val title: String) {
    object Home : Screen("home")
    object Notifications : Screen("notifications")
    object Settings : Screen("settings")
    object Grades : Screen("grades")
    object SchoolActivities : Screen("my_activities")
}