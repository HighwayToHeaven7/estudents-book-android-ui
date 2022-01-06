package pl.mjurek.highwaytoheaven.app.feature_settings.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import pl.mjurek.highwaytoheaven.app.R

@Composable
fun LogoutPopupScreen() {
    var expanded by remember { mutableStateOf(false) }
    Column {
        Text("Some text")
        Box {
            Image(
                painter = painterResource(R.drawable.user_data),
                contentDescription = "more options button",
                modifier = Modifier
                    .clickable {
                        expanded = true
                    }
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                DropdownMenuItem(onClick = { expanded = false }) {
                    Text("Delete")
                }
                DropdownMenuItem(onClick = { expanded = false }) {
                    Text("Save")
                }
            }
        }
    }
}