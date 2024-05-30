package com.hajar.managementusers.view

import android.widget.Button
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hajar.managementusers.repositry.viewModel.UserViewModel
import org.w3c.dom.Text

@Composable
fun LoginScreen(userViewModel: UserViewModel = viewModel(), onLoginSuccess: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )
        errorMessage?.let { Text(text = it, color = MaterialTheme.colors.error) }
        Spacer(modifier = java.nio.file.WatchEvent.Modifier.height(16.dp))
        Button(onClick = {
            userViewModel.loginUser(email, password, onLoginSuccess) {
                errorMessage = it
            }
        }) {
            Text("Login")
        }
    }
}
