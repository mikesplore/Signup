package com.mike.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import kotlin.math.max

@Composable
fun Loginscreen(navController: NavController){
    var email by remember{ mutableStateOf("") }
    var password by remember{ mutableStateOf("") }
    var nullEmail by remember { mutableStateOf(false)}
    var nullPassword by remember { mutableStateOf(false)}


    val upperbrush = Brush.horizontalGradient(
        colors = listOf(
            Color(0xff008DDA),
            Color(0xff1D24CA),
            Color(0xff6200EA),
            Color(0xffA100FF)

            )
    )

    val lowerbrush = Brush.linearGradient(
        colors = listOf(
            Color(0xff008DDA),
            Color(0xff1D24CA),
            Color(0xff6200EA),
            Color(0xffA100FF)


        )
    )
    val middlebrush = Brush.horizontalGradient(
        colors = listOf(
            Color(0xff008DDA),
            Color(0xff1D24CA),
            Color(0xff6200EA),
            Color(0xffA100FF)


        )
    )
    val borderbrush = Brush.linearGradient(
        colors = listOf(
            Color(0xff008DDA),
            Color(0xff1D24CA),



        )
    )
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .background(brush = upperbrush)
        .fillMaxSize(),
       verticalArrangement = Arrangement.SpaceBetween) {
        Box(
            modifier = Modifier

                .height(200.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .background(
                        Color(0xff67C6E3),
                        shape = RoundedCornerShape(topStart = 20.dp, 0.dp, 20.dp, 20.dp)
                    )
                    .size(100.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            Color(0xff1D24CA),
                            shape = RoundedCornerShape(topStart = 25.dp, 25.dp, 25.dp, 0.dp)
                        )
                        .size(50.dp)

                )
            }
        }


       Column(modifier = Modifier
           .border(
               border = BorderStroke(1.dp, brush = borderbrush),
               shape = RoundedCornerShape(70.dp, 0.dp, 0.dp, 0.dp))
           .background(brush = lowerbrush, shape = RoundedCornerShape(topStart = 70.dp))
           .height(750.dp)
           .fillMaxWidth(),

           ){
           Spacer(modifier = Modifier.height(50.dp))
           Row (modifier = Modifier
               .height(100.dp)
               .fillMaxWidth(),
               verticalAlignment = Alignment.CenterVertically,
               horizontalArrangement = Arrangement.Center){
                Text(text = "Login",
                    style = TextStyle(),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.Monospace,
                    color = Color.White
                )
           }
           Spacer(modifier = Modifier.height(50.dp))
           Column (modifier = Modifier

               .background(brush = middlebrush, shape = RoundedCornerShape(10.dp))
               .height(170.dp)
               .fillMaxWidth(),
               horizontalAlignment = Alignment.CenterHorizontally,
               verticalArrangement = Arrangement.SpaceAround){
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
                       unfocusedTextColor = Color.Black,
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
                        nullPassword = false
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
                       unfocusedTextColor = Color.Black,
                       focusedContainerColor = Color(0xff008DDA),
                       unfocusedContainerColor = Color(0xff008DDA),
                       unfocusedLabelColor = Color.Black,
                       focusedIndicatorColor = Color.Black,
                       unfocusedIndicatorColor = Color.Transparent,

                       ),


                   )
               AnimatedVisibility(visible = nullPassword) {
                   Text(text = "Password can't be empty", style = TextStyle(),
                       fontWeight = FontWeight.Normal,
                       fontFamily = FontFamily.SansSerif,
                       fontSize = 15.sp,
                       color = Color.Red)

               }
           }

Spacer(modifier = Modifier.height(30.dp))

           Row (modifier = Modifier
               .height(50.dp)
               .width(350.dp),
               horizontalArrangement = Arrangement.End){
               Text(text = "Forgot Password?",style = TextStyle(),
                   fontSize = 15.sp,
                   fontWeight = FontWeight.Normal,
                   color = Color.Black)
               Text(text = " Reset", style = TextStyle(),
                   color = Color(0xff1D24CA),
                   fontWeight = FontWeight.Bold,
                   fontSize = 15.sp)

           }
           Box(modifier = Modifier
               .height(100.dp)
               .fillMaxWidth(), contentAlignment = Alignment.BottomCenter){
               Button(onClick = {
                   if (password.isEmpty()) {
                       nullPassword = true;
                   } else {
                       nullPassword = false;
                   }

                   nullEmail = if (email.isEmpty()) {
                       true;
                   } else {
                       false;
                   }

                   if (!nullPassword && !nullEmail) {
                       navController.navigate("signup");
                   }},

                   modifier = Modifier
                       .height(50.dp)
                       .width(350.dp),

                   shape = RoundedCornerShape(10.dp,0.dp,10.dp,10.dp)


                   ,colors = ButtonDefaults.buttonColors(Color(0xff1D24CA))) {
                   Text(text = "Login", style = TextStyle(),
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
               Text(text = "Dont have an Account?",style = TextStyle(),
                   fontFamily = FontFamily.SansSerif,
                   fontWeight = FontWeight.Normal,
                   color = Color.Black,
                   )
               Text(text = " Sign Up",
                   style = TextStyle(),
                   fontFamily = FontFamily.SansSerif,
                   fontWeight = FontWeight.Bold,
                   color = Color(0xff1D24CA),
                   modifier = Modifier.clickable { navController.navigate("signup") }
              )

           }


       }



   }

}


@Preview
@Composable
fun Loginpreview(){
    Loginscreen(navController = rememberNavController())
}
