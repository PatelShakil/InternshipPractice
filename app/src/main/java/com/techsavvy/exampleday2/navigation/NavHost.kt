package com.techsavvy.exampleday2.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.techsavvy.exampleday2.ui.screens.HomeScreen
import com.techsavvy.exampleday2.ui.screens.LoginScreen
import com.techsavvy.exampleday2.ui.screens.RegisterScreen

@Composable
fun NavHostMap(modifier: Modifier = Modifier) {

    val navController = rememberNavController();

    NavHost(
        navController = navController,
        startDestination = Screens.Login.route
    ){
        composable(Screens.Login.route){
            LoginScreen(navController = navController)
        }
        //share name to register screen

        composable(
            Screens.Register.route + "/{name}",
            arguments = listOf(
                navArgument(
                    name = "name",
                    builder = {
                        defaultValue = "ABCD"
                    }
                )
            )
        ){
//            String? vs String
//            String
            RegisterScreen(name = it.arguments?.getString("name")!!, navController = navController)
        }

        composable(Screens.Home.route){
            HomeScreen(navController = navController)

        }


    }

}
//Write Screens object for managing my screens
sealed class Screens(val route:String){
    object Login : Screens("login")
    object Register : Screens("register")
    object Home : Screens("home")

}