package pl.mjurek.highwaytoheaven.app.feature_auth.data.repository

import android.content.SharedPreferences
import pl.mjurek.highwaytoheaven.app.R
import pl.mjurek.highwaytoheaven.app.core.util.Constants
import pl.mjurek.highwaytoheaven.app.core.util.Resource
import pl.mjurek.highwaytoheaven.app.core.util.SimpleResource
import pl.mjurek.highwaytoheaven.app.core.util.UiText
import pl.mjurek.highwaytoheaven.app.feature_auth.data.remote.AuthApi
import pl.mjurek.highwaytoheaven.app.feature_auth.data.remote.request.LoginRequest
import pl.mjurek.highwaytoheaven.app.feature_auth.domain.repository.AuthRepository
import retrofit2.HttpException
import java.io.IOException

class AuthRepositoryImpl(
    private val api: AuthApi,
    private val sharedPreferences: SharedPreferences
) : AuthRepository {

    override suspend fun login(email: String, password: String): SimpleResource {
        val request = LoginRequest(email, password)
        return try {
            val response = api.login(request)

            println("Overriding token with ${response.token}")
            sharedPreferences.edit()
                .putString(Constants.KEY_JWT_TOKEN, response.token)
                .putString(Constants.KEY_USER_ID, response.userUuid)
                .apply()
            Resource.Success(Unit)
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch (e: HttpException) {
            if (e.code().equals(403)) {
                Resource.Error(
                    uiText = UiText.StringResource(R.string.wrong_email_or_password)
                )
            } else
                Resource.Error(
                    uiText = UiText.StringResource(R.string.oops_something_went_wrong)
                )
        }
    }
}