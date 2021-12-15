package pl.mjurek.highwaytoheaven.app.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import pl.mjurek.highwaytoheaven.app.R
import pl.mjurek.highwaytoheaven.app.presentation.BottomNavItem

@Composable
fun HomeScreen(
    navController: NavController,
    userActions: List<UserAction>
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.students_image),
            contentDescription = "Main menu icon"
        )

        userActions.forEach { action ->
            Spacer(Modifier.height(24.dp))
            Text(
                text = action.name,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.clickable {
                    navController.navigate(action.navigation)
                }
            )

        }
    }
}

@Composable
fun UserActionComposable(userAction: UserAction, onItemClick: (BottomNavItem) -> Unit) {
    Row(
        modifier = Modifier
            .padding(all = 10.dp)
            .border(width = 2.dp, color = Color.LightGray, shape = RoundedCornerShape(5.dp))
            .fillMaxWidth()
            .background(color = Color(0x8F89A1AA)),

        ) {

    }
}