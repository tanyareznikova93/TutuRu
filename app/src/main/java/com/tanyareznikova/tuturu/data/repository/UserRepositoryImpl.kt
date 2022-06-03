package com.tanyareznikova.tuturu.data.repository

import com.tanyareznikova.tuturu.data.api.GithubApi
import com.tanyareznikova.tuturu.data.api.dto.UserDetailDto
import com.tanyareznikova.tuturu.data.api.dto.UserListDto
import com.tanyareznikova.tuturu.data.database.dao.UserDao
import com.tanyareznikova.tuturu.data.database.entity.UserDetailEntity
import com.tanyareznikova.tuturu.data.database.entity.UserListEntity
import com.tanyareznikova.tuturu.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: GithubApi,
    private val dao: UserDao
) : UserRepository {

    /*
    *  Api
    */
    override suspend fun getUsers(): List<UserListDto> {
        return api.getUsers()
    }

    override suspend fun getUserByUsername(username: String): UserDetailDto {
        return api.getUserByUsername(username)
    }


    /*
    * Room
    */
    override suspend fun getUsersFromDb(): List<UserListEntity> {
        return dao.selectUserList()
    }

    override suspend fun getUserByUsernameFromDb(username: String): UserDetailEntity {
        return dao.selectUserDetail(username)
    }

    override suspend fun insertUsersIntoDb(userList: List<UserListEntity>) {
        dao.insertUserList(userList)
    }

    override suspend fun deleteUsersFromDb() {
        dao.clearUserList()
    }

    override suspend fun insertUserIntoDb(userDetail: UserDetailEntity) {
        dao.insertUserDetail(userDetail)
    }

    override suspend fun deleteUserFromDb() {
        dao.clearUserDetail()
    }


}