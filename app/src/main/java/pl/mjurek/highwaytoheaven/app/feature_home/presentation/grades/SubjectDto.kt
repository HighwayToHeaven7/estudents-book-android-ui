package pl.mjurek.highwaytoheaven.app.feature_home.presentation.grades

data class SubjectDto(
    val subject: String,
    val group: String,
    val semester: String,
    val expectedGrade: String,
    val rows: List<Grades>
)

data class Grades(
    val grade: String,
    val weight: String,
    val description: String
)