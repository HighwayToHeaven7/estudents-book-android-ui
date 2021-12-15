package pl.mjurek.highwaytoheaven.app.domain.notification

import pl.mjurek.highwaytoheaven.app.presentation.notifications.Notification

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