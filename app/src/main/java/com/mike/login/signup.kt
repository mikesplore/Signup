package com.mike.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Signupscreen(navController: NavController){
    Column(modifier = Modifier
        .background(Color.Black)
        .verticalScroll(rememberScrollState())
        .fillMaxSize(),
        verticalArrangement = Arrangement.Top) {
        Box(modifier = Modifier
            .height(150.dp)
            .fillMaxWidth(),
            contentAlignment = Alignment.Center){
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {

                Button(
                    onClick = { /* TODO: Handle button click */ },
                    colors = ButtonDefaults.buttonColors(Color.Black)
                ) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Back Arrow",
                        tint = Color.White // Set the color of the arrow icon to white
                    )
                }
                Text(text = "Sign Up",style = TextStyle(),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    color = Color.White
                )
                Box(modifier = Modifier.width(50.dp))
            }

        }

        Column(modifier = Modifier
            .background(Color.White, shape = RoundedCornerShape(topStart = 70.dp))
            .height(750.dp)
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally

            ){

            Spacer(modifier = Modifier.height(35.dp))
            Column (modifier = Modifier

                .background(Color(0xfffafafa))
                .height(360.dp)

                .width(350.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween){
                OutlinedTextField(
                    value = "Michael",
                    onValueChange = { /*TODO*/ },
                    label = { Text("First Name", style = TextStyle(),
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp,
                        color = Color.Black
                    ) },
                    modifier = Modifier

                        .width(350.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Gray,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        unfocusedLabelColor = Color.Black,
                        focusedIndicatorColor = Color.Black,
                        unfocusedIndicatorColor = Color.Transparent,


                        ),


                    )
                OutlinedTextField(
                    value = "Odhiambo",
                    onValueChange = { /*TODO*/ },
                    label = { Text("Last Name", style = TextStyle(),
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp,
                        color = Color.Black
                    ) },
                    modifier = Modifier
                        .width(350.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Gray,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        unfocusedLabelColor = Color.Black,
                        focusedIndicatorColor = Color.Black,
                        unfocusedIndicatorColor = Color.Transparent,


                        ),


                    )
                OutlinedTextField(
                    value = "mikepremium8@gmail.com",
                    onValueChange = { /*TODO*/ },
                    label = { Text("Email", style = TextStyle(),
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp,
                        color = Color.Black
                    ) },
                    modifier = Modifier
                        .width(350.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Gray,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        unfocusedLabelColor = Color.Black,
                        focusedIndicatorColor = Color.Black,
                        unfocusedIndicatorColor = Color.Transparent,


                        ),


                    )
                OutlinedTextField(
                    value = "mikemike",
                    onValueChange = { /*TODO*/ },
                    label = { Text("Password", style = TextStyle(),
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp,
                        color = Color.Black
                    ) },
                    modifier = Modifier
                        .width(350.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Gray,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        unfocusedLabelColor = Color.Black,
                        focusedIndicatorColor = Color.Black,
                        unfocusedIndicatorColor = Color.Transparent,


                        ),


                    )
                OutlinedTextField(
                    value = "mikemike",
                    onValueChange = { /*TODO*/ },
                    label = { Text("Confirm Password", style = TextStyle(),
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp,
                        color = Color.Black
                    ) },
                    modifier = Modifier
                        .width(350.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Gray,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        unfocusedLabelColor = Color.Black,
                        focusedIndicatorColor = Color.Black,
                        unfocusedIndicatorColor = Color.Transparent,







                        ),


                    )
            }

            Spacer(modifier = Modifier.height(30.dp))
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                Button(onClick = { navController.navigate("login") },
                    modifier = Modifier
                        .height(50.dp)
                        .width(350.dp),

                    shape = RoundedCornerShape(10.dp,0.dp,10.dp,10.dp)


                    ,colors = ButtonDefaults.buttonColors(Color.Black)) {
                    Text(text = "Sign Up", style = TextStyle(),
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp,
                        color = Color.White)



                }
            }

            Box(modifier = Modifier
                .height(170.dp)
                .fillMaxWidth(), contentAlignment = Alignment.BottomCenter){
                Text(text = "Already have an account? Sign In",style = TextStyle(),
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp,
                    color = Color.Black)
            }



        }



    }

}


@Preview
@Composable
fun SignupPreview(){
    Signupscreen(navController = rememberNavController())
}