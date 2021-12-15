package pl.mjurek.highwaytoheaven.app.domain.fake

import android.util.Log
import pl.mjurek.highwaytoheaven.app.domain.model.notification.Notification
import pl.mjurek.highwaytoheaven.app.presentation.home.grades.CollapsableSection
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random.Default.nextInt

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

fun getFakeGrades(): List<CollapsableSection> {
    Log.i("FakeData", "getFakeGrades" + Random().nextInt())
    return if (Random().nextInt() % 2 == 0) {
        Log.i("FakeData", "getFakeGrades " + Random().nextInt())
        listOf(
            CollapsableSection(
                title = "Fruits A",
                rows = listOf("Apple", "Apricots", "Avocado")
            ),
            CollapsableSection(
                title = "Fruits B",
                rows = listOf("Banana", "Blackberries", "Blueberries")
            ),
            CollapsableSection(
                title = "Fruits C",
                rows = listOf("Cherimoya", "Cantaloupe", "Cherries", "Clementine")
            ),
            CollapsableSection(
                title = "Fruits C",
                rows = listOf("Cherimoya", "Cantaloupe", "Cherries", "Clementine")
            ),
            CollapsableSection(
                title = "Fruits C",
                rows = listOf("Cherimoya", "Cantaloupe", "Cherries", "Clementine")
            ),
            CollapsableSection(
                title = "Fruits C",
                rows = listOf("Cherimoya", "Cantaloupe", "Cherries", "Clementine")
            ),
        )
    } else
        listOf(
            CollapsableSection(
                title = "Fruits A",
                rows = listOf("Apple", "Apricots", "Avocado")
            ),
            CollapsableSection(
                title = "Fruits B",
                rows = listOf("Banana", "Blackberries", "Blueberries")
            ),
            CollapsableSection(
                title = "Fruits C",
                rows = listOf("Cherimoya", "Cantaloupe", "Cherries", "Clementine")
            ),
        )
}