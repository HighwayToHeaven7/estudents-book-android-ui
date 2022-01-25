package pl.mjurek.highwaytoheaven.app.feature_auth.presentation.util

import pl.mjurek.highwaytoheaven.app.core.util.Error

sealed class AuthError : Error() {
    object FieldEmpty : AuthError()
    object InputTooShort : AuthError()
    object InvalidEmail : AuthError()
    object InvalidPassword : AuthError()
}
