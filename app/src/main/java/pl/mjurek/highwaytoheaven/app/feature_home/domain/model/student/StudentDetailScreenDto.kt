package pl.mjurek.highwaytoheaven.app.feature_home.domain.model.student


data class StudentDetailScreenDto(
    var nameAndSurname: String?,
    val familyName: String,
    val sex: String,
    val studentsAlbumNumber: String,
    val residence: String,
    val province: String,
    val personalIdentityNumber: String,
    val dateOfBirth: String,
    val placeOfBirth: String,
    var contactData: ContactData?
)

data class ContactData(
    val phoneNumber: String,
    val anotherPhoneNumber: String,
    val email: String,
    val correspondenceAddress: String
)