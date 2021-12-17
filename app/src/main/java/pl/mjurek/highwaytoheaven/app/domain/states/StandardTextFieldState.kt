package pl.mjurek.highwaytoheaven.app.domain.states

import pl.mjurek.highwaytoheaven.app.core.util.Error

data class StandardTextFieldState(
    val text: String = "",
    val error: Error? = null
)
