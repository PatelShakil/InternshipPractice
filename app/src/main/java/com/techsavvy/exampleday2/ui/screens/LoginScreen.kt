package com.techsavvy.exampleday2.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.techsavvy.exampleday2.navigation.Screens

@Composable
fun LoginScreen(modifier: Modifier = Modifier,navController : NavController) {
    var text = "asdfa"
    val textState = remember {
        mutableStateOf("abcds")
    }

    Column {
        Text("Login Screen")
        Text(textState.value)
        TextField(
            value = textState.value,
            onValueChange = { value ->
                textState.value = value
            },
//            enabled =  false
//            readOnly =  true
        )


            Button(
            onClick = {
                textState.value = "Text Changed"
            }
        ) {
            Text("Change Text")
        }
        Button(
            onClick = {
                //Click Listener
                navController.navigate(Screens.Register.route + "/${textState.value}")
            }
        ) {
            Text("Go To Register")
        }
    }
}