package pl.mjurek.highwaytoheaven.app.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import pl.mjurek.highwaytoheaven.app.R

@Composable
fun HomeScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.students_image),
            contentDescription = "Main menu icon"
        )
        Spacer(modifier = Modifier.width(4.dp))
        UserMainActions(navController)
    }
}

@Composable
fun UserMainActions(navController: NavController) {

}
