package com.tanyareznikova.tuturu.domain.model

data class UserDetailModel(

    val avatarUrl: String?,
    val email: String?,
    val followers: Int?,
    val following: Int?,
    val login: String?,
    val name: String?

)
