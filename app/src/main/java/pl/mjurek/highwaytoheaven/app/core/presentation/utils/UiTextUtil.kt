package pl.mjurek.highwaytoheaven.app.core.presentation.utils

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import pl.mjurek.highwaytoheaven.app.core.util.UiText

@Composable
fun UiText.asString(): String {
    return when (this) {
        is UiText.DynamicString -> this.value
        is UiText.StringResource -> stringResource(id = this.id)
    }
}

fun UiText.asString(context: Context): String {
    return when (this) {
        is UiText.DynamicString -> this.value
        is UiText.StringResource -> context.getString(this.id)
    }
}