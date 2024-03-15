package com.mike.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyScreens()

        }
    }
}

@Composable
fun MyScreens(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login" ) {
        composable("login"){ Loginscreen(navController = navController)}
        composable("signup"){ Signupscreen(navController = navController)}
        composable("profile"){ Profile(navController = navController) }


    }
}