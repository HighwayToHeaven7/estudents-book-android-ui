package pl.mjurek.highwaytoheaven.app.feature_home.domain.model.student



data class StudentDetailDto (
    val nameAndSurname: String,
    val familyName: String,
    val sex: String,
    val studentsAlbumNumber: String,
    val residence: String,
    val province: String,
    val personalIdfentityNumber: String,
    val dateOfBith: String,
    val placeOfBith: String
)