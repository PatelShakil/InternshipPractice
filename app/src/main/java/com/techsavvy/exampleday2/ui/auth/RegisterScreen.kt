package com.techsavvy.exampleday2.ui.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.techsavvy.exampleday2.navigation.Screens

@Composable
fun RegisterScreen(viewModel: AuthViewModel,navController : NavController) {
    Column(modifier = Modifier.fillMaxWidth()
        .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        var email by remember{ mutableStateOf("") }
        var password by remember{ mutableStateOf("") }


        Text("Register Screen")
        Spacer(Modifier.height(14.dp))

        TextField(
            email,
            onValueChange = {
                email = it
            }
        )
        Spacer(Modifier.height(14.dp))

        TextField(
            password,
            onValueChange = {
                password = it
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )
        Spacer(Modifier.height(14.dp))

        Button(
            onClick = {
                viewModel.register(email, password)
            }
        ) {
            Text("Register")
        }

        Spacer(Modifier.height(14.dp))

        Button(
            onClick = {
                navController.popBackStack()
            }
        ) {
            Text("Go to Login")
        }
    }
}