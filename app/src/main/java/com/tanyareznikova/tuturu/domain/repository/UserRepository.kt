package com.tanyareznikova.tuturu.domain.repository

import com.tanyareznikova.tuturu.data.api.dto.UserDetailDto
import com.tanyareznikova.tuturu.data.api.dto.UserListDto

interface UserRepository {

    suspend fun getUsers(): List<UserListDto>
    suspend fun getUserByUsername(username: String): UserDetailDto

}