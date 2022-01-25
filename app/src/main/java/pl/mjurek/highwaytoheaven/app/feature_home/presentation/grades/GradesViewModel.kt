package pl.mjurek.highwaytoheaven.app.feature_home.presentation.grades

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pl.mjurek.highwaytoheaven.app.core.util.Resource
import pl.mjurek.highwaytoheaven.app.feature_home.domain.use_case.GetStudentSubjectsAndGradesUseCase
import javax.inject.Inject

@HiltViewModel
class GradesViewModel @Inject constructor(
    private val getStudentSubject: GetStudentSubjectsAndGradesUseCase
) : ViewModel() {
    private val _studentSubjectState = mutableStateOf(createDefault())
    val studentSubjectState = _studentSubjectState


    init{
        loadStudentSubjectData()
    }

    private fun loadStudentSubjectData() {
        viewModelScope.launch{
            val result = getStudentSubject()
            when(result){
                is Resource.Success ->{
                    _studentSubjectState.value = result.data!!
                }
                is Resource.Error ->{

                }
            }
        }
    }

    private fun createDefault(): List<SubjectDto> {
        return listOf(SubjectDto())
    }
}