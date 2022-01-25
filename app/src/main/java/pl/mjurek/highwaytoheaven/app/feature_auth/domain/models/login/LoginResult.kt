package pl.mjurek.highwaytoheaven.app.feature_auth.domain.models.login

import pl.mjurek.highwaytoheaven.app.core.util.SimpleResource
import pl.mjurek.highwaytoheaven.app.feature_auth.presentation.util.AuthError


data class LoginResult(
    val emailError: AuthError? = null,
    val passwordError: AuthError? = null,
    val result: SimpleResource? = null
)
