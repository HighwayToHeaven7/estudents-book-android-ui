package pl.mjurek.highwaytoheaven.app.core.presentation

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import pl.mjurek.highwaytoheaven.app.presentation.ui.AppTheme
import pl.mjurek.highwaytoheaven.app.core.presentation.utils.Navigation

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        setContent {
            AppTheme {
                val navController = rememberNavController()
                Scaffold(
//                    bottomBar = {
//                        BottomNavigationBar(
//                            items = listOf(
//                                BottomNavItem(
//                                    name = "Home",
//                                    route = "home",
//                                    icon = Icons.Default.Home
//                                ),
//                                BottomNavItem(
//                                    name = "Notifications",
//                                    route = "notifications",
//                                    icon = Icons.Default.Notifications,
//                                    badgeCount = 3
//                                ),
//                                BottomNavItem(
//                                    name = "Settings",
//                                    route = "settings",
//                                    icon = Icons.Default.Settings
//                                )
//                            ),
//                            navController = navController,
//                            onItemClick = {
//                                navController.navigate(it.route)
//                            }
//                        )
//                    }
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