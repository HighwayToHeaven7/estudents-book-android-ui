package pl.mjurek.highwaytoheaven.app.feature_auth.data.remote


import AuthResponse
import pl.mjurek.highwaytoheaven.app.core.data.dto.response.BasicApiResponse
import pl.mjurek.highwaytoheaven.app.feature_auth.data.remote.request.LoginRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApi {

    @POST("/users/authenticate")
    suspend fun login(
        @Body request: LoginRequest
    ): BasicApiResponse<AuthResponse>

    companion object {
        const val BASE_URL = "http://192.168.0.2:8080/"
    }
}