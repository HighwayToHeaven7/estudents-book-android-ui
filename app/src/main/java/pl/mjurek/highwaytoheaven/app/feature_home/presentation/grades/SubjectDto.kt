package pl.mjurek.highwaytoheaven.app.feature_home.presentation.grades

data class SubjectDto(
    val subject: String = "",
    val group: String = "",
    val semester: String = "",
    val expectedGrade: String = "",
    val grades: List<GradesDto> = listOf()
)

data class GradesDto(
    val grade: String = "",
    val weight: String = "",
    val description: String = ""
)