package pl.mjurek.highwaytoheaven.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.navigation.compose.rememberNavController
import pl.mjurek.highwaytoheaven.app.presentation.BottomNavItem
import pl.mjurek.highwaytoheaven.app.presentation.BottomNavigationBar
import pl.mjurek.highwaytoheaven.app.presentation.Navigation
import pl.mjurek.highwaytoheaven.app.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavItem(
                                    name = "Home",
                                    route = "home",
                                    icon = Icons.Default.Home
                                ),
                                BottomNavItem(
                                    name = "Notifications",
                                    route = "notifications",
                                    icon = Icons.Default.Notifications,
                                    badgeCount = 3
                                ),
                                BottomNavItem(
                                    name = "Settings",
                                    route = "settings",
                                    icon = Icons.Default.Settings
                                )
                            ),
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                ) {
                    Navigation(navController = navController)
                }
            }
        }
    }
}


//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    AppTheme {
//        Section("Android")
//    }
//}