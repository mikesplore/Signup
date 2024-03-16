package com.mike.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
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
    GlobalVariables.visible.value = false
    var firstname by remember{ mutableStateOf("")}
    var lastname by remember{ mutableStateOf("")}
    var email by remember{ mutableStateOf("")}
    var password by remember{ mutableStateOf("")}
    var confirmpassword by remember{ mutableStateOf("")}
    var fnError by remember { mutableStateOf(false)}
    var lnError by remember { mutableStateOf(false)}
    var nullEmail by remember { mutableStateOf(false)}
    var pError by remember { mutableStateOf(false)}
    var cpError by remember { mutableStateOf(false)}
    var errormsg by remember { mutableStateOf("Field cant b empty")}

    val upperbrush = Brush.linearGradient(
        colors = listOf(
            Color(0xff008DDA),
            Color(0xff1D24CA),
            Color(0xff6200EA),
            Color(0xffA100FF)

        )
    )

    val lowerbrush = Brush.horizontalGradient(
        colors = listOf(
            Color(0xff008DDA),
            Color(0xff1D24CA),
            Color(0xff6200EA),
            Color(0xffA100FF)


        )
    )

    Column(modifier = Modifier
        .background(brush = upperbrush)
        .verticalScroll(rememberScrollState())
        .fillMaxSize(),
        verticalArrangement = Arrangement.Top) {
        Box(modifier = Modifier
            .height(150.dp)
            .fillMaxWidth(),
            contentAlignment = Alignment.Center){
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {

                Button(
                    onClick = { navController.popBackStack() },
                    colors = ButtonDefaults.buttonColors(Color.Transparent)
                ) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Back Arrow",
                        tint = Color.White
                    )
                    
                }
                Box(modifier = Modifier.width(70.dp))

                Text(text = "Sign Up",style = TextStyle(),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    color = Color.White
                )
                Box(modifier = Modifier.width(120.dp))

            }

        }

        Column(modifier = Modifier
            .background(brush = lowerbrush, shape = RoundedCornerShape(topStart = 70.dp))
            .height(750.dp)
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally

            ){

            Spacer(modifier = Modifier.height(35.dp))
            Column (modifier = Modifier

                .background(brush = upperbrush, shape = RoundedCornerShape(10.dp))
                .height(420.dp)

                .width(350.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                ){
                OutlinedTextField(
                    value = firstname,
                    onValueChange = {
                        fnError = false
                        firstname = it},
                    label = { Text("First Name", style = TextStyle(),
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        color = Color.Black
                    ) },
                    modifier = Modifier

                        .width(350.dp),
                    maxLines = 1,
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color(0xff1D24CA),
                        focusedContainerColor = Color(0xff008DDA),
                        unfocusedContainerColor = Color(0xff008DDA),
                        unfocusedLabelColor = Color.Black,
                        focusedIndicatorColor = Color.Black,
                        unfocusedIndicatorColor = Color.Transparent,


                        ),


                    )
                AnimatedVisibility(visible = fnError) {
                    Text(text = "First Name can't be empty", style = TextStyle(),
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 15.sp,
                        color = Color.Red)
                    
                }
                OutlinedTextField(
                    value = lastname,
                    onValueChange = {
                        lnError = false
                        lastname = it },
                    label = { Text("Last Name", style = TextStyle(),
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        color = Color.Black
                    ) },
                    modifier = Modifier
                        .width(350.dp),
                    maxLines = 1,
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color(0xff1D24CA),
                        focusedContainerColor = Color(0xff008DDA),
                        unfocusedContainerColor = Color(0xff008DDA),
                        unfocusedLabelColor = Color.Black,
                        focusedIndicatorColor = Color.Black,
                        unfocusedIndicatorColor = Color.Transparent,


                        ),


                    )
                AnimatedVisibility(visible = lnError) {
                    Text(text = "last Name can't be empty", style = TextStyle(),
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 15.sp,
                        color = Color.Red)

                }
                OutlinedTextField(
                    value = email,
                    onValueChange = {
                        nullEmail = false
                        email = it },
                    label = { Text("Email", style = TextStyle(),
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        color = Color.Black
                    ) },
                    modifier = Modifier
                        .width(350.dp),
                    maxLines = 1,
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color(0xff1D24CA),
                        focusedContainerColor = Color(0xff008DDA),
                        unfocusedContainerColor = Color(0xff008DDA),
                        unfocusedLabelColor = Color.Black,
                        focusedIndicatorColor = Color.Black,
                        unfocusedIndicatorColor = Color.Transparent,


                        ),


                    )
                AnimatedVisibility(visible = nullEmail) {
                    Text(text = "Email can't be empty", style = TextStyle(),
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 15.sp,
                        color = Color.Red)

                }
                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        pError = false
                        password = it },
                    label = { Text("Password", style = TextStyle(),
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        color = Color.Black
                    ) },
                    modifier = Modifier
                        .width(350.dp),
                    maxLines = 1,
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color(0xff1D24CA),
                        focusedContainerColor = Color(0xff008DDA),
                        unfocusedContainerColor = Color(0xff008DDA),
                        unfocusedLabelColor = Color.Black,
                        focusedIndicatorColor = Color.Black,
                        unfocusedIndicatorColor = Color.Transparent,


                        ),


                    )
                AnimatedVisibility(visible = pError) {
                    Text(text = "Password can't be empty", style = TextStyle(),
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 15.sp,
                        color = Color.Red)

                }
                val errormsg by remember { mutableStateOf("Password not matching")}
                OutlinedTextField(
                    value = confirmpassword,
                    onValueChange = {
                        cpError = false
                        confirmpassword = it },
                    label = { Text("Confirm Password", style = TextStyle(),
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        color = Color.Black
                    ) },
                    modifier = Modifier
                        .width(350.dp),
                    shape = RoundedCornerShape(10.dp),
                    maxLines = 1,
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color(0xff1D24CA),
                        focusedContainerColor = Color(0xff008DDA),
                        unfocusedContainerColor = Color(0xff008DDA),
                        unfocusedLabelColor = Color.Black,
                        focusedIndicatorColor = Color.Black,
                        unfocusedIndicatorColor = Color.Transparent,
                        ),

                    )
                AnimatedVisibility(visible = cpError) {
                    Text(text = errormsg, style = TextStyle(),
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 15.sp,
                        color = Color.Red)

                }
            }



            Column(modifier = Modifier
                .height(150.dp)
                .fillMaxWidth(), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally){

                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                    Button(onClick = {
                        pError = password.isEmpty()

                        cpError = confirmpassword.isEmpty()
                        if (password != confirmpassword) {
                            errormsg = "Password not Matching";
                            cpError = true
                        } else {
                            cpError = false;
                        }

                        fnError = firstname.isEmpty()
                        lnError = lastname.isEmpty()

                        nullEmail = email.isEmpty()

                        if (!pError && !nullEmail && !fnError && !cpError && !lnError) {
                            navController.navigate("profile");
                        }

                    },
                        modifier = Modifier
                            .height(50.dp)
                            .width(350.dp),
                        shape = RoundedCornerShape(10.dp,0.dp,10.dp,10.dp)
                        ,colors = ButtonDefaults.buttonColors(Color(0xff1D24CA))) {
                        Text(text = "Sign Up", style = TextStyle(),
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 15.sp,
                            color = Color.White)



                    }
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Bottom) {
                    Text(text = "Already have an Account?",style = TextStyle(),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                        color = Color.White,
                    )
                    Text(text = " Sign In",
                        style = TextStyle(),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xff008DDA),
                        modifier = Modifier.clickable { navController.navigate("login") }
                    )

                }

            }



        }



    }

}


@Preview
@Composable
fun SignupPreview() {
    Signupscreen(navController = rememberNavController())
}
