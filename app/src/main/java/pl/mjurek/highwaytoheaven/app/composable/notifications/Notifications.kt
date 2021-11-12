package pl.mjurek.highwaytoheaven.app.composable.notifications

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.mjurek.highwaytoheaven.app.R
import pl.mjurek.highwaytoheaven.app.domain.notification.getFakeNotification
import pl.mjurek.highwaytoheaven.app.ui.theme.AppTheme
import pl.mjurek.highwaytoheaven.app.domain.notification.getFakeNotification

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
            .padding(all = 10.dp)
            .border(width = 2.dp, color = Color.Blue, shape = RoundedCornerShape(5.dp))
            .fillMaxWidth()
            .background(color = Color(0x8F80DBFF))
    ) {
        Image(
            painter = painterResource(R.drawable.notification_icon),
            contentDescription = "Notification icon",
            modifier = Modifier
                .size(40.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = notification.message,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(4.dp)
            )
        }
//        IconButton(
//            onClick = {
//
//            }
//        ) {
//            Icon(
//                Icons.Filled.CheckCircle,
//                contentDescription = "Dismiss notification.",
//                tint = Color.DarkGray,
//                modifier = Modifier.size(30.dp)
//            )
//        }

    }
}

@Preview
@Composable
fun NotificationScreenPreview() {
    AppTheme {
        NotificationsScreen(getFakeNotification())
    }
}
