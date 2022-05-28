package com.tanyareznikova.tuturu.domain.model

import com.google.gson.annotations.SerializedName

data class UserListModel(

    val avatarUrl: String?,
    val id: Int?,
    val login: String?,
    val nodeId: String?,
    val reposUrl: String?,
    val siteAdmin: Boolean,
    val type: String?,
    val url: String?
)
