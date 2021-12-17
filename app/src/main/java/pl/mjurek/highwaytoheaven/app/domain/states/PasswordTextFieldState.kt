package pl.mjurek.highwaytoheaven.app.domain.states

import pl.mjurek.highwaytoheaven.app.core.util.Error

data class PasswordTextFieldState(
    val text: String = "",
    val error: Error? = null,
    val isPasswordVisible: Boolean = false
)
