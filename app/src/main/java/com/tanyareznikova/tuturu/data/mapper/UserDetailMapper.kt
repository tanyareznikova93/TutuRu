package com.tanyareznikova.tuturu.data.mapper

import com.tanyareznikova.tuturu.data.api.dto.UserDetailDto
import com.tanyareznikova.tuturu.data.database.entity.UserDetailEntity
import com.tanyareznikova.tuturu.domain.model.UserDetailModel

/*
* User Detail Dto Mapper
*/
fun UserDetailDto.toUserDetail() : UserDetailModel {

    return UserDetailModel(
        avatarUrl = avatarUrl,
        email = email,
        followers = followers,
        following = following,
        login = login,
        name = name
    )

}

/*
* User Detail Entity Mapper
*/
fun UserDetailEntity.toUserDetailModel() : UserDetailModel {

    return UserDetailModel(
        avatarUrl = avatarUrl,
        email = email,
        followers = followers,
        following = following,
        login = login,
        name = name
    )

}

fun UserDetailModel.toUserDetailEntity() : UserDetailEntity {

    return UserDetailEntity(
        avatarUrl = avatarUrl,
        email = email,
        followers = followers,
        following = following,
        login = login,
        name = name
    )

}