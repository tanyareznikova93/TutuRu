package com.tanyareznikova.tuturu.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tanyareznikova.tuturu.data.database.dao.UserDao
import com.tanyareznikova.tuturu.data.database.entity.UserDetailEntity
import com.tanyareznikova.tuturu.data.database.entity.UserListEntity

@Database(
    entities = [UserListEntity::class, UserDetailEntity::class],
    version = 1
)
abstract class UserDatabase: RoomDatabase() {
    abstract val dao: UserDao
}