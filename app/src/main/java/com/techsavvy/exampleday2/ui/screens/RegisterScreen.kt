package com.techsavvy.exampleday2.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun RegisterScreen(modifier: Modifier = Modifier,name: String,navController : NavController) {
    Column {
        Text(name)
        Text("Register Screen")
        Button(
            onClick = {
                //Click Listener
                navController.navigate("home")
            }
        ) {
            Text("Go To Home")
        }
    }
}