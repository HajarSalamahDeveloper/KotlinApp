package com.example.usermanagement.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hajar.managementusers.model.User
import com.hajar.managementusers.repositry.UserRepository

import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    fun registerUser(username: String, email: String, phoneNumber: String, password: String, onSuccess: () -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                // Replace with actual user registration logic
                val newUser = User(username, email, phoneNumber, password)
                userRepository.insertUser(newUser)
                onSuccess()
            } catch (e: Exception) {
                onError(e.message ?: "An error occurred")
            }
        }
    }

    fun loginUser(email: String, password: String, onSuccess: () -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                // Replace with actual user login logic
                val user = userRepository.getUserByEmail(email)
                if (user?.password == password) {
                    onSuccess()
                } else {
                    onError("Invalid credentials")
                }
            } catch (e: Exception) {
                onError(e.message ?: "An error occurred")
            }
        }
    }
}
