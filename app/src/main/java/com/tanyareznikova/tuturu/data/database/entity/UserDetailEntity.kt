package com.tanyareznikova.tuturu.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserDetailEntity(

    val avatarUrl: String?,
    val email: String?,
    val followers: Int?,
    val following: Int?,
    @PrimaryKey val id: Int? = null,
    val login: String?,
    val name: String?

)
