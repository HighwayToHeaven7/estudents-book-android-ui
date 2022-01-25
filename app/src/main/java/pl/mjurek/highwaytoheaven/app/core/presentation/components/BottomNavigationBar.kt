package pl.mjurek.highwaytoheaven.app.core.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import pl.mjurek.highwaytoheaven.app.core.util.Screen

@ExperimentalMaterialApi
@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.DarkGray,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            if (item.name.equals("Notifications")) {
                Spacer(modifier = Modifier.width(10.dp))
            } else {
                val isSelected = item.route == backStackEntry.value?.destination?.route
                BottomNavigationItem(
                    selected = isSelected,
                    onClick = {
                        if (item.route !== Screen.Settings.route) onItemClick(item) else click(
                            onItemClick(item)
                        )
                    },
                    selectedContentColor = Color.Green,
                    unselectedContentColor = Color.Gray,
                    icon = { Icons(isSelected, item) }
                )
            }
        }
    }
}

fun click(onItemClick: Unit) {
    //logout operation
    onItemClick
}

@ExperimentalMaterialApi
@Composable
fun Icons(isSelected: Boolean, item: BottomNavItem) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        if (item.badgeCount > 0) {
            BadgeBox(
                badgeContent = {
                    Text(text = item.badgeCount.toString())
                }
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.name
                )
            }
        } else {
            Icon(
                imageVector = item.icon,
                contentDescription = item.name
            )
        }
        if (isSelected) {
            Text(
                text = item.name,
                textAlign = TextAlign.Center,
                fontSize = 10.sp
            )
        }
    }
}