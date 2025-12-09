package com.techsavvy.exampleday2.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.flow.asStateFlow

@Composable
fun HomeScreen(viewModel : HomeViewModel,navController: NavController) {
    Column {
        var name by remember { mutableStateOf("") }
        val list = viewModel.namesList.asStateFlow()
//        val list by viewModel.namesList.collectAsState()
//
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                name,
                onValueChange = {
                    name = it
                }
            )
            IconButton(
                onClick = {
                    viewModel.addName(name)
                    name = ""
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            }
        }

        //Recycler View
        viewModel.namesList.collectAsState().value.forEach {
            Card(
                modifier = Modifier.fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(it,modifier = Modifier.padding(10.dp), fontSize = 24.sp)
            }
        }

        Divider(modifier = Modifier.fillMaxWidth())

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 14.dp)
        ) {
            items(list.value.size){ index ->
                val name = list.value[index]
                Card(
                    modifier = Modifier.fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(name,modifier = Modifier.padding(10.dp), fontSize = 24.sp)
                }
            }
        }
    }
}