import com.google.gson.annotations.SerializedName


data class GradesDto(

    @SerializedName("id") val id: String,
    @SerializedName("grade") val grade: Int,
    @SerializedName("weight") val weight: Int,
    @SerializedName("description") val description: String
)