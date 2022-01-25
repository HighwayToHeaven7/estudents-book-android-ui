package pl.mjurek.highwaytoheaven.app.feature_home.presentation

import androidx.compose.ui.graphics.painter.Painter

data class UserAction(
    val name: String,
    val navigation: String,
    val painter: Painter
)
