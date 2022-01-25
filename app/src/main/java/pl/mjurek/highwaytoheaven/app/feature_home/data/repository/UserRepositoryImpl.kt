package pl.mjurek.highwaytoheaven.app.feature_home.data.repository;

import pl.mjurek.highwaytoheaven.app.R
import pl.mjurek.highwaytoheaven.app.core.util.Resource
import pl.mjurek.highwaytoheaven.app.core.util.UiText
import pl.mjurek.highwaytoheaven.app.feature_home.data.remote.UserApi;
import pl.mjurek.highwaytoheaven.app.feature_home.data.remote.response.student_data.StudentData
import pl.mjurek.highwaytoheaven.app.feature_home.domain.repository.UserRepository
import retrofit2.HttpException
import java.io.IOException

class UserRepositoryImpl(
    private val userApi: UserApi,
) : UserRepository {
    override suspend fun getStudentDetails(): Resource<StudentData> {
        return try {
            val userData = userApi.getUserData()
            Resource.Success(userData)
        }catch(e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch(e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

}
