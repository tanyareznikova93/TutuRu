package com.tanyareznikova.tuturu.domain.use_case.get_users

import com.tanyareznikova.tuturu.data.api.dto.toUserList
import com.tanyareznikova.tuturu.domain.model.UserListModel
import com.tanyareznikova.tuturu.domain.repository.UserRepository
import com.tanyareznikova.tuturu.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {

    operator fun invoke(): Flow<Resource<List<UserListModel>>> = flow {

        try {
            emit(Resource.Loading<List<UserListModel>>())
            val users = repository.getUsers().map { it.toUserList() }
            emit(Resource.Success<List<UserListModel>>(users))
        } catch(e: HttpException) {
            emit(Resource.Error<List<UserListModel>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<UserListModel>>("Couldn't reach server. Check your internet connection."))
        }

    }

}