package pl.mjurek.highwaytoheaven.app.feature_home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import pl.mjurek.highwaytoheaven.app.R
import pl.mjurek.highwaytoheaven.app.core.presentation.ui.theme.SpaceLarge
import pl.mjurek.highwaytoheaven.app.core.presentation.ui.theme.SpaceMedium
import pl.mjurek.highwaytoheaven.app.core.util.Screen

@ExperimentalMaterialApi
@Composable
fun HomeScreen(
    navController: NavController,
    userActions: List<UserAction> = listOf(
        UserAction(
            name = "Oceny",
            navigation = Screen.Grades.route,
            painter = painterResource(id = R.drawable.grade),
        ),
        UserAction(
            name = "Moje dane",
            navigation = Screen.UserDetail.route,
            painter = painterResource(id = R.drawable.user_data)
        )
    )
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(SpaceLarge)
    ) {
        Image(
            painter = painterResource(id = R.drawable.students_image),
            contentDescription = "Main menu icon"
        )
        Spacer(modifier = Modifier.height(SpaceLarge))
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(userActions) { action ->
                UserMainAction(
                    userAction = action,
                    onActionClick = { navController.navigate(action.navigation) }
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
            }
        }

    }
}
