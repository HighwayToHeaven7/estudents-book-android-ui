package pl.mjurek.highwaytoheaven.app.feature_home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import pl.mjurek.highwaytoheaven.app.R
import pl.mjurek.highwaytoheaven.app.core.presentation.utils.userActions

@Composable
fun HomeScreen(
    navController: NavController,
    userActions: List<UserAction> = userActions()
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
