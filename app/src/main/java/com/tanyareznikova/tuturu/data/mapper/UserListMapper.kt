package com.tanyareznikova.tuturu.data.mapper

import com.tanyareznikova.tuturu.data.api.dto.UserListDto
import com.tanyareznikova.tuturu.data.database.entity.UserListEntity
import com.tanyareznikova.tuturu.domain.model.UserListModel

/*
* User List Dto Mapper
*/
fun UserListDto.toUserList() : UserListModel {

    return UserListModel(
        avatarUrl = avatarUrl,
        login = login
    )

}

/*
* User List Entity Mapper
*/
fun UserListEntity.toUserListModel() : UserListModel {

    return UserListModel(
        avatarUrl = avatarUrl,
        login = login
    )

}

fun UserListModel.toUserListEntity() : UserListEntity {

    return UserListEntity(
        avatarUrl = avatarUrl,
        login = login
    )

}