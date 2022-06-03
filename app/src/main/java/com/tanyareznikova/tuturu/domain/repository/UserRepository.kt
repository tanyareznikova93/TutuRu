package com.tanyareznikova.tuturu.domain.repository

import com.tanyareznikova.tuturu.data.api.dto.UserDetailDto
import com.tanyareznikova.tuturu.data.api.dto.UserListDto
import com.tanyareznikova.tuturu.data.database.entity.UserDetailEntity
import com.tanyareznikova.tuturu.data.database.entity.UserListEntity

interface UserRepository {

    /*
    * Api
    */
    suspend fun getUsers(): List<UserListDto>
    suspend fun getUserByUsername(username: String): UserDetailDto


    /*
    * Room
    */
    suspend fun getUsersFromDb(): List<UserListEntity>
    suspend fun getUserByUsernameFromDb(username: String): UserDetailEntity
    suspend fun insertUsersIntoDb(userList: List<UserListEntity>)
    suspend fun deleteUsersFromDb()
    suspend fun insertUserIntoDb(userDetail: UserDetailEntity)
    suspend fun deleteUserFromDb()

}