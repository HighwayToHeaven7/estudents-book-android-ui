package pl.mjurek.highwaytoheaven.app.feature_auth.data.remote


import AuthResponse
import pl.mjurek.highwaytoheaven.app.feature_auth.data.remote.request.LoginRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("/users/auth")
    suspend fun login(
        @Body request: LoginRequest
    ): AuthResponse

    companion object {
        const val BASE_URL = "http://192.168.1.42:8080"
    }
}