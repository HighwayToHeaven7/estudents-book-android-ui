package pl.mjurek.highwaytoheaven.app.core.presentation.components

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import pl.mjurek.highwaytoheaven.app.core.util.Screen

@ExperimentalMaterialApi
@Composable
fun StandardScaffold(
    navController: NavController,
    modifier: Modifier = Modifier,
    shouldShowBottomBar: Boolean = true,
    state: ScaffoldState,
    bottomNavItems: List<BottomNavItem> = getButtonNavItems(),
    content: @Composable () -> Unit
) {
    Scaffold(
        bottomBar = {
            if (shouldShowBottomBar) {
                BottomNavigationBar(
                    items = bottomNavItems,
                    navController = navController,
                    onItemClick = {
                        navController.navigate(it.route)
                    }
                )
            }
        },
        scaffoldState = state,
        modifier = modifier
    ) {
        content()
    }
}

fun getButtonNavItems(): List<BottomNavItem> {
    return listOf(
        BottomNavItem(
            name = "Home",
            route = Screen.Home.route,
            icon = Icons.Default.Home
        ),
        BottomNavItem(
            name = "Notifications",
            route = Screen.Notifications.route,
            icon = Icons.Default.Notifications,
            badgeCount = 3
        ),
        BottomNavItem(
            name = "Logout",
            route = Screen.Login.route,
            icon = Icons.Default.Logout
        )
    )
}
