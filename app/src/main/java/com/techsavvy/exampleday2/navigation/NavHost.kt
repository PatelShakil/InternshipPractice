package com.techsavvy.exampleday2.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.techsavvy.exampleday2.ui.home.HomeScreen
import com.techsavvy.exampleday2.ui.auth.LoginScreen
import com.techsavvy.exampleday2.ui.auth.RegisterScreen

@Composable
fun NavHostMap(modifier: Modifier = Modifier) {

    val navController = rememberNavController();

    NavHost(
        navController = navController,
        startDestination = Screens.Login.route
    ){
        composable(Screens.Login.route){
            LoginScreen(hiltViewModel(),navController = navController)
        }
        //share name to register screen

        composable(
            Screens.Register.route,
        ){
//            String? vs String
//            String
            RegisterScreen(hiltViewModel(),  navController = navController)
        }

        composable(Screens.Home.route){
            HomeScreen(hiltViewModel(), navController = navController)
        }


    }

}
//Write Screens object for managing my screens
sealed class Screens(val route:String){
    object Login : Screens("login")
    object Register : Screens("register")
    object Home : Screens("home")

}