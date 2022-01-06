package pl.mjurek.highwaytoheaven.app.core.presentation

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import pl.mjurek.highwaytoheaven.app.core.presentation.components.Navigation
import pl.mjurek.highwaytoheaven.app.core.presentation.components.StandardScaffold
import pl.mjurek.highwaytoheaven.app.core.util.Screen
import pl.mjurek.highwaytoheaven.app.presentation.ui.AppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        setContent {
            AppTheme {
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val scaffoldState = rememberScaffoldState()

                    StandardScaffold(
                        navController = navController,
                        state = scaffoldState,
                        modifier = Modifier.fillMaxSize(),
                        shouldShowBottomBar = shouldShowBottomBar(navBackStackEntry)
                    ) {
                        Navigation(navController = navController, scaffoldState = scaffoldState)
                    }

                }
            }
        }
    }

    private fun shouldShowBottomBar(navBackStackEntry: NavBackStackEntry?): Boolean {
        return navBackStackEntry?.destination?.route in listOf(
            Screen.Home.route,
            Screen.Settings.route,
            Screen.Notifications.route
        )
    }
}
