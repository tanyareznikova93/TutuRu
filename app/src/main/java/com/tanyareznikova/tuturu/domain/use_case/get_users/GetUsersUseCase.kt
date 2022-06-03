package com.tanyareznikova.tuturu.domain.use_case.get_users

import com.tanyareznikova.tuturu.data.mapper.toUserList
import com.tanyareznikova.tuturu.data.mapper.toUserListEntity
import com.tanyareznikova.tuturu.data.mapper.toUserListModel
import com.tanyareznikova.tuturu.domain.model.UserListModel
import com.tanyareznikova.tuturu.domain.repository.UserRepository
import com.tanyareznikova.tuturu.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {

    operator fun invoke(): Flow<Resource<List<UserListModel>>> = flow {

        try {

            val getDataFromDB = repository.getUsersFromDb().map { it.toUserListModel() }
            if(getDataFromDB.isEmpty()){
                emit(Resource.Loading<List<UserListModel>>())
                val users = repository.getUsers().map { it.toUserList() }
                //repository.deleteUsersFromDb()
                users.forEach { insertData ->

                    repository.insertUsersIntoDb(
                        listOf(insertData.toUserListEntity()).toMutableList()
                    )

                }
                emit(Resource.Success<List<UserListModel>>(users))
            } else {
                emit(Resource.Success<List<UserListModel>>(getDataFromDB))
            }

        } catch(e: HttpException) {
            emit(Resource.Error<List<UserListModel>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException) {
            emit(Resource.Error<List<UserListModel>>("Couldn't reach server. Check your internet connection."))
        }

    }

}