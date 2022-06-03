package com.tanyareznikova.tuturu.domain.use_case.get_users

import com.google.common.truth.Truth.assertThat
import com.tanyareznikova.tuturu.data.database.entity.UserListEntity
import com.tanyareznikova.tuturu.data.repository.FakeUserRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetUsersUseCaseTest {

    private lateinit var getUsersUseCase: GetUsersUseCase
    private lateinit var fakeUserRepository: FakeUserRepository

    @Before
    fun setUp(){
        fakeUserRepository = FakeUserRepository()
        getUsersUseCase = GetUsersUseCase(fakeUserRepository)

        val usersToInsert = mutableListOf<UserListEntity>()
        ('a'..'z').forEach { c ->
            usersToInsert.add(
                UserListEntity(
                    avatarUrl = c.toString(),
                    login = c.toString()
                )
            )
        }
        usersToInsert.shuffle()
        runBlocking {
            usersToInsert.forEach { fakeUserRepository.insertUsersIntoDb(listOf(it)) }
        }
    }

    @Test
    fun `Loading a list of users from the database`() = runBlocking {

        val fakeRepository = fakeUserRepository

        val loadUsers = fakeRepository.getUsersFromDb()
        assertThat(loadUsers).isNotNull()

    }

    @Test
    fun `Inserting a list of users into the database`() = runBlocking {

        val fakeRepository = fakeUserRepository

        val usersToInsert = mutableListOf<UserListEntity>()
        ('a'..'z').forEach { c ->
            usersToInsert.add(
                UserListEntity(
                    avatarUrl = c.toString(),
                    login = c.toString()
                )
            )
        }
        usersToInsert.shuffle()

        val data = usersToInsert.forEach { fakeRepository.insertUsersIntoDb(listOf(it)) }
        assertThat(data).isNotNull()

    }

}