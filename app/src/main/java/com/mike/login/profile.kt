package com.mike.login

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun Profile(navController: NavController){
    GlobalVariables.visible.value = true
    var fullname by remember { mutableStateOf("Michael Odhiambo")}
    var email by remember { mutableStateOf("mikepremium8@gmail.com")}
    var phone by remember { mutableStateOf("+254799013845")}
    var facebook by remember { mutableStateOf("Mike Mike")}
    var username by remember { mutableStateOf("mikesplore")}

    val profilebrush = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF2196F3), // Blue
            Color(0xFF9C27B0)

        )
    )

    val backcustomBrush = Brush.linearGradient(
        colors = listOf(
            Color(0xFF2196F3), // Blue
            Color(0xFF9C27B0)
        )
    )
    Column(modifier = Modifier
        .background(brush = backcustomBrush)
        .fillMaxSize()) {
        Column(
            modifier = Modifier
                .height(320.dp)
                .background(
                    brush = profilebrush,
                    shape = RoundedCornerShape(0.dp, 0.dp, 20.dp, 20.dp)
                )
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Row (modifier = Modifier
                .absolutePadding(0.dp, 30.dp)
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround){

            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow back",
                tint = Color.White,
                modifier = Modifier.clickable { navController.popBackStack() }
            )
            Spacer(modifier = Modifier.width(90.dp))
            Text(
                text = "Profile",
                style = TextStyle(),
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
            Spacer(modifier = Modifier.width(90.dp))
                var topuppertext by remember { mutableStateOf("Edit") }

                Box(
                    modifier = Modifier
                        .clickable {
                            GlobalVariables.editenabled.value = !GlobalVariables.editenabled.value
                            topuppertext = if (GlobalVariables.editenabled.value) "Save" else "Edit"
                        }
                ) {
                    Text(text = topuppertext,
                        style = TextStyle(),
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif
                    )
                }
        }
            Spacer(modifier = Modifier.height(10.dp))
            Column(modifier = Modifier
                .height(300.dp)
                .width(300.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly){


                var imageUri by remember { mutableStateOf<Uri?>(null) }
                val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
                    imageUri = uri
                }

                val painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(data = imageUri)
                        .crossfade(true)
                        .fallback(drawableResId = R.drawable.pic) // Replace with your default icon resource ID
                        .build()
                )

                Box(
                    modifier = Modifier
                        .size(130.dp)
                        .background(Color.White, shape = CircleShape)
                        .border(3.dp, color = Color(0xff67C6E3), shape = CircleShape)
                        .clickable(
                            enabled = GlobalVariables.editenabled.value
                        ) {
                            launcher.launch("image/*")


                        },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painter,
                        contentDescription = "profile",
                        modifier = Modifier
                            .size(130.dp)
                            .clip(shape = CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }


                Column (horizontalAlignment = Alignment.CenterHorizontally){
                    Text(text = fullname, style = TextStyle(),
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        fontSize = 30.sp)
                    Text(text = "Android Developer", style = TextStyle(),
                        fontWeight = FontWeight.Bold,
                        color = Color(0xff67C6E3),
                        fontSize = 16.sp
                        )
                }


                Row (modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly){
                    Column(verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "1000", style = TextStyle(),
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 18.sp)
                        Text(text = "Followers", style = TextStyle(),
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xff67C6E3),
                            fontSize = 15.sp)
                    }


                    Spacer(modifier = Modifier.width(10.dp))
                    Divider(color = Color.White,modifier = Modifier
                        .width(1.dp)
                        .height(40.dp))
                    Spacer(modifier = Modifier.width(10.dp))

                    Column(verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "1500", style = TextStyle(),
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 18.sp)
                        Text(text = "Following", style = TextStyle(),
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xff67C6E3),
                            fontSize = 15.sp)
                    }

                }
            }

        }
    Spacer(modifier = Modifier.height(20.dp))

        Column (verticalArrangement = Arrangement.Center,
            ){
            val backcustomBrush = Brush.horizontalGradient(
                colors = listOf(
                    Color(0xFF2196F3), // Blue
                    Color(0xFF9C27B0)
                )
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Spacer(modifier = Modifier.width(25.dp))


                    Column(
                        modifier = Modifier
                            .background(
                                brush = backcustomBrush,
                                shape = RoundedCornerShape(20.dp, 0.dp)
                            )
                            .fillMaxWidth()
                            .height(90.dp),
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .background(
                                        Color(0xff008DDA),
                                        shape = RoundedCornerShape(20.dp)
                                    )
                                    .size(40.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = "Name",
                                    modifier = Modifier.size(30.dp),
                                    tint = Color.White
                                )
                            }
                            Text(
                                text = "  Full Name",
                                style = TextStyle(),
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Normal,
                                fontFamily = FontFamily.SansSerif,
                                color = Color.White
                            )
                        }
                        TextField(
                            value = fullname,
                            textStyle = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 15.sp,
                                color = Color.White // Set the text color
                            ),
                            onValueChange = { fullname = it },
                            modifier = Modifier
                                .height(50.dp),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                unfocusedTextColor = Color.White,
                                cursorColor = Color.White,
                                focusedLabelColor = Color.White,
                                unfocusedLabelColor = Color.White,
                                disabledContainerColor = Color.Transparent
                            ),
                            singleLine = true,
                            enabled = GlobalVariables.editenabled.value
                        )


                    }
                }

            Row(
                modifier = Modifier
                    .height(90.dp)
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(25.dp))


                Column(
                    modifier = Modifier
                        .background(brush = backcustomBrush)
                        .fillMaxWidth()
                        .height(90.dp),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .background(
                                    Color(0xff008DDA),
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .size(40.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Name",
                                modifier = Modifier.size(30.dp),
                                tint = Color.White
                            )
                        }
                        Text(
                            text = "  Username",
                            style = TextStyle(),
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.White
                        )
                    }
                    TextField(
                        value = username,
                        textStyle = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 15.sp,
                            color = Color.White // Set the text color
                        ),
                        onValueChange = { username   = it.takeLastWhile { it != ' ' } },
                        modifier = Modifier
                            .height(50.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            unfocusedTextColor = Color.White,
                            cursorColor = Color.White,
                            focusedLabelColor = Color.White,
                            unfocusedLabelColor = Color.White,
                            disabledContainerColor = Color.Transparent
                        ),
                        singleLine = true,
                        enabled = GlobalVariables.editenabled.value
                    )


                }
            }

            Row(
                modifier = Modifier
                    .height(90.dp)
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(25.dp))


                Column(
                    modifier = Modifier
                        .background(brush = backcustomBrush)
                        .fillMaxWidth()
                        .height(90.dp),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .background(
                                    Color(0xff008DDA),
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .size(40.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = "Username",
                                modifier = Modifier.size(30.dp),
                                tint = Color.White
                            )
                        }
                        Text(
                            text = "  Email",
                            style = TextStyle(),
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.White
                        )
                    }
                    TextField(
                        value = email,
                        textStyle = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 15.sp,
                            color = Color.White // Set the text color
                        ),
                        onValueChange = { email = it.takeLastWhile { it != ' ' } },
                        modifier = Modifier
                            .height(50.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            unfocusedTextColor = Color.White,
                            cursorColor = Color.White,
                            focusedLabelColor = Color.White,
                            unfocusedLabelColor = Color.White,
                            disabledContainerColor = Color.Transparent
                        ),
                        singleLine = true,
                        enabled = GlobalVariables.editenabled.value
                    )


                }
            }

            Row(
                modifier = Modifier
                    .height(90.dp)
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(25.dp))


                Column(
                    modifier = Modifier
                        .background(brush = backcustomBrush, shape = RoundedCornerShape(0.dp, 0.dp))
                        .fillMaxWidth()
                        .height(90.dp),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .background(
                                    Color(0xff008DDA),
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .size(40.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Phone,
                                contentDescription = "Phone",
                                modifier = Modifier.size(30.dp),
                                tint = Color.White
                            )
                        }
                        Text(
                            text = "  Phone",
                            style = TextStyle(),
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.White
                        )
                    }
                    TextField(
                        value = phone,
                        textStyle = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 15.sp,
                            color = Color.White // Set the text color
                        ),
                        onValueChange = { phone  = it.takeLastWhile { it != ' ' } },
                        modifier = Modifier
                            .height(50.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            unfocusedTextColor = Color.White,
                            cursorColor = Color.White,
                            focusedLabelColor = Color.White,
                            unfocusedLabelColor = Color.White,
                            disabledContainerColor = Color.Transparent
                        ),
                        singleLine = true,
                        enabled = GlobalVariables.editenabled.value
                    )


                }
            }

            Row(
                modifier = Modifier
                    .height(90.dp)
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(25.dp))


                Column(
                    modifier = Modifier
                        .background(
                            brush = backcustomBrush,
                            shape = RoundedCornerShape(0.dp, 0.dp, 20.dp)
                        )
                        .fillMaxWidth()
                        .height(90.dp),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .background(
                                    Color(0xff008DDA),
                                    shape = RoundedCornerShape(20.dp)
                                )
                                .size(40.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(painter = painterResource(id = R.drawable.ig), contentDescription = "facebook",
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(shape = RoundedCornerShape(20.dp)))
                        }
                        Text(
                            text = "  Instagram",
                            style = TextStyle(),
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.White
                        )
                    }
                    TextField(
                        value = facebook,
                        textStyle = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 15.sp,
                            color = Color.White
                        ),
                        onValueChange = {facebook = it  },
                        modifier = Modifier
                            .height(50.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            unfocusedTextColor = Color.White,
                            cursorColor = Color.White,
                            focusedLabelColor = Color.White,
                            unfocusedLabelColor = Color.White,
                            disabledContainerColor = Color.Transparent
                        ),
                        singleLine = true,
                        enabled = GlobalVariables.editenabled.value
                        
                    )


                }
            }

            }





    }

}

@Preview
@Composable
fun ProfilePreview(){
Profile(rememberNavController())
}