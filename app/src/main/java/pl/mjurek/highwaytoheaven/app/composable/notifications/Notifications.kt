package pl.mjurek.highwaytoheaven.app.composable.notifications

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.mjurek.highwaytoheaven.app.R
import pl.mjurek.highwaytoheaven.app.domain.notification.getFakeNotification
import pl.mjurek.highwaytoheaven.app.ui.theme.AppTheme

@Composable
fun NotificationsScreen(notifications: List<Notification>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(notifications) { notification ->
            NotificationRow(notification)
        }
    }
}

@Composable
fun NotificationRow(notification: Notification) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.notification_icon),
            contentDescription = "Notification icon"
        )

    }
}

//@Preview
//@Composable
//fun NotificationScreenPreview(fakeNotification: List<Notification> = getFakeNotification()) {
//    AppTheme {
//        NotificationScreenPreview()
//    }
//}
