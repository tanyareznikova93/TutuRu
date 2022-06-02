package com.tanyareznikova.tuturu.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tanyareznikova.tuturu.data.database.entity.UserDetailEntity
import com.tanyareznikova.tuturu.data.database.entity.UserListEntity

@Dao
interface UserDao {

    /*
    * User Detail Dao
    */

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserDetail(
        userDetail: UserDetailEntity
    )

    @Query("DELETE FROM userdetailentity")
    suspend fun clearUserDetail()

    @Query("SELECT * FROM userdetailentity WHERE name = :username")
    suspend fun selectUserDetail(username: String): UserDetailEntity


    /*
    * User List Dao
    */

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserList(
        userList: List<UserListEntity>
    )

    @Query("DELETE FROM userlistentity")
    suspend fun clearUserList()

    @Query("SELECT * FROM userlistentity")
    suspend fun selectUserList(): List<UserListEntity>

}