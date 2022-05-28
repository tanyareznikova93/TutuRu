package com.tanyareznikova.tuturu.data.repository

import com.tanyareznikova.tuturu.data.api.GithubApi
import com.tanyareznikova.tuturu.data.api.dto.UserDetailDto
import com.tanyareznikova.tuturu.data.api.dto.UserListDto
import com.tanyareznikova.tuturu.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: GithubApi
) : UserRepository {

    override suspend fun getUsers(): List<UserListDto> {
        return api.getUsers()
    }

    override suspend fun getUserByUsername(username: String): UserDetailDto {
        return api.getUserByUsername(username)
    }

}