package com.hajar.managementusers.repositry

import com.hajar.managementusers.data.UserDao
import com.hajar.managementusers.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(private val userDao: UserDao) {

    suspend fun registerUser(username: String, email: String, phoneNumber: String, password: String) {
        val user = User(
            username = username,
            email = email,
            phoneNumber = phoneNumber,
            passwordHash = password // Hash password in a real app
        )
        withContext(Dispatchers.IO) {
            userDao.insert(user)
        }
    }

    suspend fun loginUser(email: String, password: String): User? {
        return withContext(Dispatchers.IO) {
            val user = userDao.findByEmail(email)
            if (user != null && user.passwordHash == password) {
                user
            } else {
                null
            }
        }
    }
}
