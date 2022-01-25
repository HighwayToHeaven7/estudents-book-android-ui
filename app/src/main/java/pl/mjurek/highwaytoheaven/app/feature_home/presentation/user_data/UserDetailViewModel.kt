package pl.mjurek.highwaytoheaven.app.feature_home.presentation.user_data

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pl.mjurek.highwaytoheaven.app.core.util.Resource
import pl.mjurek.highwaytoheaven.app.feature_home.domain.model.student.ContactData
import pl.mjurek.highwaytoheaven.app.feature_home.domain.model.student.StudentDetailScreenDto
import pl.mjurek.highwaytoheaven.app.feature_home.domain.use_case.GetStudentDetailsUseCase
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val getDetailUseCase: GetStudentDetailsUseCase
) : ViewModel() {

    private val _userDetailState = mutableStateOf(createDefaultStudent())

    val userDetailDataState = _userDetailState

    private val _loadingState = mutableStateOf(false)

    val loadingState: State<Boolean> = _loadingState

    init {
        loadStudentData()
    }

    private fun loadStudentData() {
        viewModelScope.launch {
            _loadingState.value = true
            val result = getDetailUseCase()
            when (result) {
                is Resource.Success -> {
                    result.data?.let { _userDetailState.value = it }
                    _loadingState.value = false
                }
                is Resource.Error -> {

                }
            }
        }
    }

}

private fun createDefaultStudent(): StudentDetailScreenDto {
    return StudentDetailScreenDto(
        nameAndSurname = "Jan, Jacek Stępień",
        familyName = "-",
        sex = "Mężczyzna",
        studentsAlbumNumber = "D/123321",
        residence = "Lenartowicza Teofila 13 Krakow, Poland",
        province = "Małopolskie",
        personalIdentityNumber = "48081375648",
        dateOfBirth = "20-10-1995",
        placeOfBirth = "Kraków",
        contactData = ContactData(
            phoneNumber = "+48 678143876",
            anotherPhoneNumber = "-",
            correspondenceAddress = "Lenartowicza Teofila 13/6 Krakow, Poland",
            email = "example.email@gmail.com"
        )
    )
}
