package com.tanyareznikova.tuturu.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserListEntity(

    val avatarUrl: String?,
    @PrimaryKey val id: Int? = null,
    val login: String?

)
