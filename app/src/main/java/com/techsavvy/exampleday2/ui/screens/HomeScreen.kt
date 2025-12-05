package com.techsavvy.exampleday2.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(modifier: Modifier = Modifier,navController: NavController) {
    Column {
        Text(
            "Home Screen",
            fontSize = 44.sp
        )
        Button(
            onClick = {
                //Click Listener
                navController.navigate("login")
            }
        ) {
            Text("Go To Login")
        }
    }
}