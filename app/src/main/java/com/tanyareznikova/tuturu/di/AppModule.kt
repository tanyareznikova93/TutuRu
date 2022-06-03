package com.tanyareznikova.tuturu.di

import android.app.Application
import androidx.room.Room
import com.tanyareznikova.tuturu.data.api.GithubApi
import com.tanyareznikova.tuturu.data.database.UserDatabase
import com.tanyareznikova.tuturu.data.repository.UserRepositoryImpl
import com.tanyareznikova.tuturu.domain.repository.UserRepository
import com.tanyareznikova.tuturu.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGithubApi(): GithubApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserDatabase(app: Application): UserDatabase {
        return Room.databaseBuilder(
            app,
            UserDatabase::class.java,
            "users.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideUserRepository(api: GithubApi, db: UserDatabase): UserRepository {
        return UserRepositoryImpl(api, db.dao)
    }

}