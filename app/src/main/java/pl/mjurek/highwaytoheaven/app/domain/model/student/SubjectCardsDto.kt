import com.google.gson.annotations.SerializedName


data class SubjectCardsDto (

	@SerializedName("groupName") val groupName : String,
	@SerializedName("semesterNumber") val semesterNumber : Int,
	@SerializedName("subjectName") val subjectName : String,
	@SerializedName("expectedGrade") val expectedGrade : Int,
	@SerializedName("grades") val grades : List<GradesDto>
)