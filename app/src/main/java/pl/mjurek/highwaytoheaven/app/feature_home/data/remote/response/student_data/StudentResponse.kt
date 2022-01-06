package pl.mjurek.highwaytoheaven.app.feature_home.data.remote.response.student_data

import com.google.gson.annotations.SerializedName

data class StudentData(
    @SerializedName("id") var id: String? = null,
    @SerializedName("personalData") var personalData: PersonalData? = PersonalData(),
    @SerializedName("subjectCards") var subjectCards: ArrayList<SubjectCards> = arrayListOf()
)

data class Contact(
    @SerializedName("phoneNumber") var phoneNumber: String? = null
)

data class PersonalData(
    @SerializedName("id") var id: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("surname") var surname: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("role") var role: String? = null,
    @SerializedName("contact") var contact: Contact? = Contact()
)

data class Grades(
    @SerializedName("id") var id: String? = null,
    @SerializedName("grade") var grade: Int? = null,
    @SerializedName("weight") var weight: Int? = null,
    @SerializedName("description") var description: String? = null
)

data class SubjectCards(
    @SerializedName("groupName") var groupName: String? = null,
    @SerializedName("semesterNumber") var semesterNumber: Int? = null,
    @SerializedName("subjectName") var subjectName: String? = null,
    @SerializedName("expectedGrade") var expectedGrade: Int? = null,
    @SerializedName("grades") var grades: ArrayList<Grades> = arrayListOf()
)