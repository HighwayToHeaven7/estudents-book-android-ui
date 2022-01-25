package pl.mjurek.highwaytoheaven.app.feature_auth.domain.repository

import pl.mjurek.highwaytoheaven.app.core.util.SimpleResource


interface AuthRepository {

    suspend fun login(
        email: String,
        password: String
    ): SimpleResource
}