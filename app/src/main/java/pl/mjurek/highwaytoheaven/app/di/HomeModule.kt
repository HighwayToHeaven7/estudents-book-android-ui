package pl.mjurek.highwaytoheaven.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import pl.mjurek.highwaytoheaven.app.feature_home.data.remote.UserApi
import pl.mjurek.highwaytoheaven.app.feature_home.data.repository.UserRepositoryImpl
import pl.mjurek.highwaytoheaven.app.feature_home.domain.repository.UserRepository
import pl.mjurek.highwaytoheaven.app.feature_home.domain.use_case.GetStudentDetailsUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {
    @Provides
    @Singleton
    fun provideUserApi(client: OkHttpClient): UserApi {
        return Retrofit.Builder()
            .baseUrl(UserApi.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(api: UserApi): UserRepository {
        return UserRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideUserDetailGetUseCase(repository: UserRepository): GetStudentDetailsUseCase {
        return GetStudentDetailsUseCase(repository);
    }

}