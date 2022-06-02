package com.tanyareznikova.tuturu.data.api

import com.tanyareznikova.tuturu.data.api.dto.UserDetailDto
import com.tanyareznikova.tuturu.data.api.dto.UserListDto
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {

    //get user list
    //https://api.github.com/users
    @GET("/users")
    suspend fun getUsers(): List<UserListDto>

    //get user
    //https://api.github.com/users/USERNAME
    @GET("users/{username}")
    suspend fun getUserByUsername(@Path("username") username: String): UserDetailDto


}