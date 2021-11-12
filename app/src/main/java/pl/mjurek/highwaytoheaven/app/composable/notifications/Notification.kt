package pl.mjurek.highwaytoheaven.app.composable.notifications

import androidx.compose.ui.graphics.painter.Painter

data class Notification(
    val title: String,
    val message: String,
    val image: Painter? = null
)

