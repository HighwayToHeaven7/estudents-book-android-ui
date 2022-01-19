package pl.mjurek.highwaytoheaven.app.feature_home.data.remote

import pl.mjurek.highwaytoheaven.app.core.util.Resource
import pl.mjurek.highwaytoheaven.app.feature_home.data.remote.response.student_data.StudentData
import retrofit2.http.GET

interface UserApi {

    @GET("/users/students")
    suspend fun getUserData(): StudentData

    companion object {
        const val BASE_URL = "http://192.168.1.42:8080"
    }
}