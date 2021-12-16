import com.google.gson.annotations.SerializedName


data class ContactDto(

    @SerializedName("phoneNumber") val phoneNumber: String
)