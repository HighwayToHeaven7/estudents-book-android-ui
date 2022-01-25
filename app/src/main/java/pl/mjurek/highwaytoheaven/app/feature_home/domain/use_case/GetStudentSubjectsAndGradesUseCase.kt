package pl.mjurek.highwaytoheaven.app.feature_home.domain.use_case

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers
import pl.mjurek.highwaytoheaven.app.core.util.Resource
import pl.mjurek.highwaytoheaven.app.core.util.UiText
import pl.mjurek.highwaytoheaven.app.feature_home.data.remote.response.student_data.Grades
import pl.mjurek.highwaytoheaven.app.feature_home.data.remote.response.student_data.SubjectCards
import pl.mjurek.highwaytoheaven.app.feature_home.domain.repository.UserRepository
import pl.mjurek.highwaytoheaven.app.feature_home.presentation.grades.GradesDto
import pl.mjurek.highwaytoheaven.app.feature_home.presentation.grades.SubjectDto
import java.lang.Exception

class GetStudentSubjectsAndGradesUseCase(private val userRepository: UserRepository) {
    val subjectMapper: SubjectMapper = SubjectMapper()

    suspend operator fun invoke(): Resource<List<SubjectDto>> {
        return try {
            val studentDetails = userRepository.getStudentDetails()
            val subjects = studentDetails.data?.subjectCards ?: emptyList()
            val subjectsDto =
                subjectMapper.mapSubjectCardsToPresentationDto(subjects)
            Resource.Success(subjectsDto)
        } catch (e: Exception) {
            Resource.Error(uiText = UiText.unknownError())
        }
    }
}


class SubjectMapper {

    fun mapSubjectCardsToPresentationDto(subjects: List<SubjectCards>): List<SubjectDto>{
        return subjects.map { mapSubjectCardToPresentationDto(it) }
    }

    fun mapSubjectCardToPresentationDto(subjectCard: SubjectCards): SubjectDto {
        val subject = subjectCard.subjectName ?: "subject"
        val group = subjectCard.groupName ?: "group"
        val semester = subjectCard.semesterNumber.toString()
        val expectedGrade = subjectCard.expectedGrade.toString()
        val grades = mapGradesApiToPresentationDto(subjectCard.grades)

        return SubjectDto(
            subject = subject,
            group = group,
            semester = semester,
            expectedGrade = expectedGrade,
            grades = grades
        )
    }

    fun mapGradesApiToPresentationDto(grades: List<Grades>): List<GradesDto> {
        return grades.map { mapGradeApiToPresentationDto(it) }
    }

    fun mapGradeApiToPresentationDto(it: Grades): GradesDto {
        val grade = it.grade.toString()
        val weight = it.weight.toString()
        val description = it.description ?: ""
        return GradesDto(
            grade = grade,
            weight = weight,
            description = description
        )
    }

}