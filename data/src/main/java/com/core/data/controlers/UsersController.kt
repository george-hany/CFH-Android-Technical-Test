package com.core.data.controlers

import com.app.database.users.UserEntity
import com.app.database.users.UsersDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UsersController @Inject constructor(private val dao: UsersDao) {

    suspend fun insertUserEntity(
        firstName: String,
        lastName: String,
        age: Int,
        email: String,
        password: String
    ) =
        withContext(Dispatchers.IO) {
            val user = UserEntity(
                firstName = firstName.trim(),
                lastName = lastName.trim(),
                age = age,
                email = email.trim(),
                password = password.trim()
            )
            dao.insertUserEntity(user)
        }


    fun getUserByEmail(email: String) = dao.getUserEntity(email)

    fun deleteUserEntity(email: String) = dao.deleteUserEntity(email)
}