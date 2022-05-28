package com.tanyareznikova.tuturu.domain.use_case.get_user

import com.tanyareznikova.tuturu.data.api.dto.toUserDetail
import com.tanyareznikova.tuturu.data.api.dto.toUserList
import com.tanyareznikova.tuturu.domain.model.UserDetailModel
import com.tanyareznikova.tuturu.domain.model.UserListModel
import com.tanyareznikova.tuturu.domain.repository.UserRepository
import com.tanyareznikova.tuturu.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: UserRepository
) {

    operator fun invoke(username: String): Flow<Resource<UserDetailModel>> = flow {

        try {
            emit(Resource.Loading<UserDetailModel>())
            val user = repository.getUserByUsername(username).toUserDetail()
            emit(Resource.Success<UserDetailModel>(user))
        } catch(e: HttpException) {
            emit(Resource.Error<UserDetailModel>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<UserDetailModel>("Couldn't reach server. Check your internet connection."))
        }

    }

}