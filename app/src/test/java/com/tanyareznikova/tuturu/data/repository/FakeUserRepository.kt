package com.tanyareznikova.tuturu.data.repository

import com.tanyareznikova.tuturu.data.api.dto.UserDetailDto
import com.tanyareznikova.tuturu.data.api.dto.UserListDto
import com.tanyareznikova.tuturu.data.database.entity.UserDetailEntity
import com.tanyareznikova.tuturu.data.database.entity.UserListEntity
import com.tanyareznikova.tuturu.domain.repository.UserRepository

class FakeUserRepository: UserRepository {

    // Api
    private val userListApi = mutableListOf<UserListDto>()
    private val userDetailApi = mutableListOf<UserDetailDto>()

    // Room
    private val userListDb = mutableListOf<UserListEntity>()
    private val userDetailDb = mutableListOf<UserDetailEntity>()

    override suspend fun getUsers(): List<UserListDto> {
        return userListApi
    }

    override suspend fun getUserByUsername(username: String): UserDetailDto {
        return userDetailApi.find { it.name == username }!!
    }

    override suspend fun getUsersFromDb(): List<UserListEntity> {
        return userListDb
    }

    override suspend fun getUserByUsernameFromDb(username: String): UserDetailEntity {
        return userDetailDb.find { it.name == username }!!
    }

    override suspend fun insertUsersIntoDb(userList: List<UserListEntity>) {
        userListDb.addAll(userList)
    }

    override suspend fun deleteUsersFromDb() {
        userListDb.clear()
    }

    override suspend fun insertUserIntoDb(userDetail: UserDetailEntity) {
        userDetailDb.add(userDetail)
    }

    override suspend fun deleteUserFromDb() {
        userDetailDb.clear()
    }
}