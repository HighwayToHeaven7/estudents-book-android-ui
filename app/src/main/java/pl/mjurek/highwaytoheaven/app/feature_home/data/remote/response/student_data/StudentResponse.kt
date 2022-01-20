package pl.mjurek.highwaytoheaven.app.feature_home.data.remote.response.student_data

import com.google.gson.annotations.SerializedName

data class StudentData(
    @SerializedName("id") var id: String? = null,
    @SerializedName("personal_data") var personalData: PersonalData? = PersonalData(),
    @SerializedName("subject_cards") var subjectCards: List<SubjectCards> = arrayListOf()
)

data class Contact(
    @SerializedName("phone_number") var phoneNumber: String? = null,
    @SerializedName("another_phone_number") var anotherPhoneNumber: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("correspondence_address") var correspondenceAddress: String? = null
)

data class PersonalData(
    @SerializedName("id") var id: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("surname") var surname: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("role") var role: String? = null,
    @SerializedName("family_name") var familyName: String? = null,
    @SerializedName("sex") var sex: String? = null,
    @SerializedName("residence") var residence: String? = null,
    @SerializedName("students_album_number") var studentsAlbumNumber: String? = null,
    @SerializedName("province") var province: String? = null,
    @SerializedName("personal_identity_number") var personalIdentityNumber: String? = null,
    @SerializedName("date_of_birth") var dateOfBirth: String? = null,
    @SerializedName("place_of_birth") var placeOfBirth: String? = null,
    @SerializedName("contact") var contact: Contact? = Contact()
)

data class Grades(
    @SerializedName("id") var id: String? = null,
    @SerializedName("grade") var grade: Double? = null,
    @SerializedName("weight") var weight: Double? = null,
    @SerializedName("description") var description: String? = null
)

data class SubjectCards(
    @SerializedName("group_name") var groupName: String? = null,
    @SerializedName("semester_number") var semesterNumber: Double? = null,
    @SerializedName("subject_name") var subjectName: String? = null,
    @SerializedName("expected_grade") var expectedGrade: Double? = null,
    @SerializedName("grades") var grades: ArrayList<Grades> = arrayListOf()
)