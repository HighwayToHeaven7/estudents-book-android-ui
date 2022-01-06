package pl.mjurek.highwaytoheaven.app.feature_home.domain.model.student


data class StudentDetailDto(
    val nameAndSurname: String,
    val familyName: String,
    val sex: String,
    val studentsAlbumNumber: String,
    val residence: String,
    val province: String,
    val personalIdentityNumber: String,
    val dateOfBirth: String,
    val placeOfBirth: String,
    val address: AddressData
)

data class AddressData(
    val phoneNumber: String,
    val anotherPhoneNumber: String,
    val email: String,
    val correspondenceAddress: String
)