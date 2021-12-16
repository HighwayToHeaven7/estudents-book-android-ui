import com.google.gson.annotations.SerializedName


data class PersonalDataDto(

    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("surname") val surname: String,
    @SerializedName("email") val email: String,
    @SerializedName("role") val role: String,
    @SerializedName("contact") val contact: ContactDto
)