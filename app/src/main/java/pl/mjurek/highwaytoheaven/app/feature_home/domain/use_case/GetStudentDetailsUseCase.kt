package pl.mjurek.highwaytoheaven.app.feature_home.domain.use_case

import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers
import pl.mjurek.highwaytoheaven.app.core.util.Resource
import pl.mjurek.highwaytoheaven.app.feature_home.data.remote.response.student_data.Contact
import pl.mjurek.highwaytoheaven.app.feature_home.data.remote.response.student_data.PersonalData
import pl.mjurek.highwaytoheaven.app.feature_home.domain.model.student.ContactData
import pl.mjurek.highwaytoheaven.app.feature_home.domain.model.student.StudentDetailScreenDto
import pl.mjurek.highwaytoheaven.app.feature_home.domain.repository.UserRepository

class GetStudentDetailsUseCase(private val userRepository: UserRepository) {
    val userMapper: UserMapper = Mappers.getMapper(UserMapper::class.java)

    suspend operator fun invoke(): Resource<StudentDetailScreenDto> {
        val studentDetails = userRepository.getStudentDetails()
        val details =
            userMapper.convert(studentDetails.data?.personalData)
        details.nameAndSurname =
            "${studentDetails.data?.personalData?.name} ${studentDetails.data?.personalData?.surname}"
        details.contactData = ContactData(
            phoneNumber = "+48 678143876",
            anotherPhoneNumber = "-",
            correspondenceAddress = "Lenartowicza Teofila 13/6 Krakow, Poland",
            email = "example.email@gmail.com"
        )
        return Resource.Success(details)
    }
}

@Mapper
interface UserMapper {
    fun convertToStudentDetailScreenDto(data: PersonalData?): StudentDetailScreenDto

    fun convertUserContactsData(contact: Contact): ContactData
    fun convert(personalData: PersonalData?): StudentDetailScreenDto {
        val mapped = convertToStudentDetailScreenDto(personalData)
        personalData?.contact?.let { mapped.contactData = convertUserContactsData(it) }
        if (personalData != null) {
            mapped.nameAndSurname = "${personalData.name}, ${personalData.surname}"
        }
        return mapped
    }
}
