package com.techsavvy.exampleday2.ui.auth

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.techsavvy.exampleday2.navigation.Screens
import com.techsavvy.exampleday2.utility.Resource
import com.techsavvy.exampleday2.utility.TempResponse

@Composable
fun LoginScreen(viewModel: AuthViewModel,navController : NavController) {
    Column(modifier = Modifier.fillMaxWidth()
        .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        var email by remember{ mutableStateOf("") }
        var password by remember{ mutableStateOf("") }


        Text("Login Screen")
        Spacer(Modifier.height(14.dp))


        viewModel.response.collectAsState().value.let {
            when (it) {
                is Resource.Loading -> {
                    CircularProgressIndicator()
                }

                is Resource.Success -> {
                    Text(if(it.result.data == true) "Username Available" else "Username Not Available",
                        color = if(it.result.data == true) Color.Green else Color.Red
                        )
                }

                is Resource.Failure -> {
                    Text(it.message.toString())
                }

                else -> {}
            }

        }
        var username by remember{mutableStateOf("")}
        TextField(
            username,
            onValueChange = {
                username = it
            }
        )
        Spacer(Modifier.height(14.dp))


        Button(
            onClick = {
                viewModel.callApi(username)
            }
        ) {
            Text("Check Username Available")
        }

        TextField(
            email,
            onValueChange = {
                email = it
            }
        )


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
                viewModel.login(email, password)
            }
        ) {
            Text("Login")
        }
        Spacer(Modifier.height(14.dp))

        Button(
            onClick = {
                navController.navigate(Screens.Register.route)
            }
        ) {
            Text("Go to Register")
        }
    }
}