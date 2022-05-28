package com.tanyareznikova.tuturu.domain.model

import com.google.gson.annotations.SerializedName

data class UserDetailModel(

    val avatarUrl: String?,
    val bio: String?,
    val blog: String?,
    val company: String?,
    val createdAt: String?,
    val email: String?,
    val followers: Int?,
    val following: Int?,
    val id: Int?,
    val location: String?,
    val login: String?,
    val name: String?,
    val nodeId: String?,
    val publicRepos: Int?,
    val reposUrl: String?,
    val type: String?,
    val updatedAt: String?,
    val url: String?

)
