package pl.mjurek.highwaytoheaven.app.feature_home.domain.repository

import pl.mjurek.highwaytoheaven.app.core.util.Resource
import pl.mjurek.highwaytoheaven.app.feature_home.data.remote.response.student_data.StudentData

interface UserRepository {
    suspend fun getStudentDetails(): Resource<StudentData>
}