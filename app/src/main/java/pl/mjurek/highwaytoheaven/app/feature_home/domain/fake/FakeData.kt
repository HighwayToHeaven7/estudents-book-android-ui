package pl.mjurek.highwaytoheaven.app.feature_home.domain.fake

import android.util.Log
import pl.mjurek.highwaytoheaven.app.feature_home.domain.model.notification.Notification
import pl.mjurek.highwaytoheaven.app.feature_home.presentation.grades.SubjectDto
import java.util.*

fun getFakeNotification(): List<Notification> {
    return listOf(
        Notification(
            title = "",
            message = "You got a grade in operating systems."
        ),
        Notification(
            title = "",
            message = "The deadline of PW_NS is approaching."
        ), Notification(
            title = "",
            message = "There is new materials on BSK nst."
        )
    )
}
