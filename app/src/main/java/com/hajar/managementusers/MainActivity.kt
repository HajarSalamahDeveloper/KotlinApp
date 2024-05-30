package com.hajar.managementusers
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val userViewModel: UserViewModel = viewModel()

            var currentScreen by remember { mutableStateOf("login") }

            if (currentScreen == "login") {
                LoginScreen(userViewModel) {
                    currentScreen = "home"
                }
            } else {
                RegisterScreen(userViewModel) {
                    currentScreen = "login"
                }
            }
        }
    }
}
