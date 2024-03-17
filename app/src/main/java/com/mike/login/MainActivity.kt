package com.mike.login

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
object GlobalVariables{
    var visible: MutableState<Boolean> = mutableStateOf(true)
    var colvisible: MutableState<Boolean> = mutableStateOf(true)
    var editenabled: MutableState<Boolean> = mutableStateOf(false)


}
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

                MyScreens()


        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyScreens() {
    val navController = rememberNavController()


    Scaffold(
        bottomBar = {

            AnimatedVisibility(visible = GlobalVariables.visible.value) {

            BottomAppBar(
                containerColor = Color(0xff6200EA),
                modifier = Modifier.height(60.dp)
            ) {



                Row (modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly){
                    Icon(imageVector = Icons.Default.Home, contentDescription ="Home" ,
                        modifier = Modifier
                            .clickable { navController.navigate("login") }
                            .size(40.dp))
                    Icon(imageVector = Icons.Default.Build, contentDescription ="Home" ,
                        modifier = Modifier
                            .clickable { navController.navigate("signup") }
                            .size(40.dp))
                    Icon(imageVector = Icons.Default.Person, contentDescription ="Home" ,
                        modifier = Modifier
                            .clickable { navController.navigate("profile") }
                            .size(40.dp))

                }


            }

        }
}


    )
    {
        NavHost(
            navController = navController,
            startDestination = "login"
        ) {
            composable("login") { Loginscreen(navController = navController) }
            composable("signup") { Signupscreen(navController = navController) }
            composable("profile") { Profile(navController = navController) }
            // Content of the screen
        }
    }
}

@Preview(heightDp = 900)
@Composable
fun mainpreview(){
    MyScreens()
}

