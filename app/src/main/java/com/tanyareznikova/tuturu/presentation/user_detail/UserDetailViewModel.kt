package com.tanyareznikova.tuturu.presentation.user_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tanyareznikova.tuturu.domain.use_case.get_user.GetUserUseCase
import com.tanyareznikova.tuturu.util.Constants
import com.tanyareznikova.tuturu.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(UserDetailState())
    val state: State<UserDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_USERNAME)?.let { username ->
            getUser(username)
        }
    }

    private fun getUser(username: String) {

        getUserUseCase(username).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = UserDetailState(user = result.data)
                }
                is Resource.Error -> {
                    _state.value = UserDetailState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = UserDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)

    }

}