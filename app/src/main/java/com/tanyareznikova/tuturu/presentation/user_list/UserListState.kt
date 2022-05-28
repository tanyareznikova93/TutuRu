package com.tanyareznikova.tuturu.presentation.user_list

import com.tanyareznikova.tuturu.domain.model.UserListModel

data class UserListState(
    val isLoading: Boolean = false,
    val users: List<UserListModel> = emptyList(),
    val error: String = ""
)
