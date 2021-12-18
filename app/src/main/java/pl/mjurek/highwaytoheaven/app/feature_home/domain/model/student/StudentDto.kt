import com.google.gson.annotations.SerializedName
import java.util.*


data class StudentDto(

    @SerializedName("id") val id: UUID,
    @SerializedName("personalData") val personalData: PersonalDataDto,
    @SerializedName("subjectCards") val subjectCards: List<SubjectCardsDto>
)