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
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.mike.login.R.drawable.x

@Composable
fun Profile(navController: NavController){
    GlobalVariables.visible.value = true
    val profilecustomBrush = Brush.horizontalGradient(
        colors = listOf(
            Color(0xff008DDA),
            Color(0xff1D24CA),
            Color(0xff6200EA),
            Color(0xffA100FF)

        )

    )

    val backcustomBrush = Brush.linearGradient(
        colors = listOf(
            Color(0xff008DDA),
            Color(0xff1D24CA),
            Color(0xff6200EA),
            Color(0xffA100FF)
        )
    )
    Column(modifier = Modifier
        .background(brush = backcustomBrush)
        .fillMaxSize()) {
        Column(
            modifier = Modifier
                .height(320.dp)
                .background(
                    brush = profilecustomBrush,
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
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Settings",
                tint = Color.White,
                modifier = Modifier.clickable { navController.navigate("login") }
            )
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
                        .clickable {
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
                    Text(text = "Michael Odhiambo", style = TextStyle(),
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

            var name by remember { mutableStateOf("Michael Odhiambo") }
            var isEditing by remember { mutableStateOf(false) }
            var newName by remember { mutableStateOf(name) }

            Row(
                modifier = Modifier
                    .height(75.dp)
                    .clickable { isEditing = !isEditing }
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(25.dp))

                if (isEditing) {
                    OutlinedTextField(
                        value = newName,
                        onValueChange = { newName = it },
                        label = { Text("Edit Name") },
                        modifier = Modifier.fillMaxWidth()
                    )
                } else {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(75.dp),
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .background(
                                        Color(0xff008DDA),
                                        shape = RoundedCornerShape(20.dp)
                                    )
                                    .size(50.dp),
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
                                text = "  Name",
                                style = TextStyle(),
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Normal,
                                fontFamily = FontFamily.SansSerif,
                                color = Color.White
                            )
                        }
                        Text(
                            text = "                $name",
                            style = TextStyle(),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.White
                        )
                    }
                }
            }

            Divider(color = Color.Gray, modifier = Modifier.width(340.dp))

            if (isEditing) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(
                        onClick = {
                            isEditing = false
                            newName = name // Reset newName to the original name
                        }
                    ) {
                        Text("Cancel")
                    }
                    TextButton(
                        onClick = {
                            isEditing = false
                            name = newName // Update the original name with the new name
                        }
                    ) {
                        Text("Save")
                    }
                }
            }


            Row(
                modifier = Modifier
                    .height(75.dp)
                    .clickable { isEditing = !isEditing }
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(25.dp))

                if (isEditing) {
                    OutlinedTextField(
                        value = newName,
                        onValueChange = { newName = it },
                        label = { Text("Edit Name") },
                        modifier = Modifier.fillMaxWidth()
                    )
                } else {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(75.dp),
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .background(
                                        Color(0xff008DDA),
                                        shape = RoundedCornerShape(20.dp)
                                    )
                                    .size(50.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Email,
                                    contentDescription = "Email",
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
                        Text(
                            text = "                mikepremium8@gmail.com",
                            style = TextStyle(),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.White
                        )
                    }
                }
            }

            Divider(color = Color.Gray, modifier = Modifier.width(340.dp))

            if (isEditing) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(
                        onClick = {
                            isEditing = false
                            newName = name // Reset newName to the original name
                        }
                    ) {
                        Text("Cancel")
                    }
                    TextButton(
                        onClick = {
                            isEditing = false
                            name = newName // Update the original name with the new name
                        }
                    ) {
                        Text("Save")
                    }
                }
            }

            Row(
                modifier = Modifier
                    .height(75.dp)
                    .clickable { isEditing = !isEditing }
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(25.dp))

                if (isEditing) {
                    OutlinedTextField(
                        value = newName,
                        onValueChange = { newName = it },
                        label = { Text("Edit Name") },
                        modifier = Modifier.fillMaxWidth()
                    )
                } else {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(75.dp),
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .background(
                                        Color(0xff008DDA),
                                        shape = RoundedCornerShape(20.dp)
                                    )
                                    .size(50.dp),
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
                                text = "  Contact",
                                style = TextStyle(),
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Normal,
                                fontFamily = FontFamily.SansSerif,
                                color = Color.White
                            )
                        }
                        Text(
                            text = "                +254799013845",
                            style = TextStyle(),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.White
                        )
                    }
                }
            }

            Divider(color = Color.Gray, modifier = Modifier.width(340.dp))

            if (isEditing) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(
                        onClick = {
                            isEditing = false
                            newName = name // Reset newName to the original name
                        }
                    ) {
                        Text("Cancel")
                    }
                    TextButton(
                        onClick = {
                            isEditing = false
                            name = newName // Update the original name with the new name
                        }
                    ) {
                        Text("Save")
                    }
                }
            }

            Row(
                modifier = Modifier
                    .height(75.dp)
                    .clickable { isEditing = !isEditing }
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(25.dp))

                if (isEditing) {
                    OutlinedTextField(
                        value = newName,
                        onValueChange = { newName = it },
                        label = { Text("Edit Name") },
                        modifier = Modifier.fillMaxWidth()
                    )
                } else {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(75.dp),
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .background(
                                        Color(0xff008DDA),
                                        shape = RoundedCornerShape(20.dp)
                                    )
                                    .size(50.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(painter = painterResource(id = R.drawable.insta), contentDescription = "Insta",
                                    modifier = Modifier
                                        .size(50.dp)
                                        .clip(shape = CircleShape)
                                )
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
                        Text(
                            text = "                mikesplore",
                            style = TextStyle(),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.White
                        )
                    }
                }
            }

            Divider(color = Color.Gray, modifier = Modifier.width(340.dp))

            if (isEditing) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(
                        onClick = {
                            isEditing = false
                            newName = name // Reset newName to the original name
                        }
                    ) {
                        Text("Cancel")
                    }
                    TextButton(
                        onClick = {
                            isEditing = false
                            name = newName // Update the original name with the new name
                        }
                    ) {
                        Text("Save")
                    }
                }
            }

            Row(
                modifier = Modifier
                    .height(75.dp)
                    .clickable { isEditing = !isEditing }
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(25.dp))

                if (isEditing) {
                    OutlinedTextField(
                        value = newName,
                        onValueChange = { newName = it },
                        label = { Text("Edit Name") },
                        modifier = Modifier.fillMaxWidth()
                    )
                } else {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(75.dp),
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .background(
                                        Color(0xff008DDA),
                                        shape = RoundedCornerShape(20.dp)
                                    )
                                    .size(50.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(painter = painterResource(id = R.drawable.face), contentDescription = "facebook",
                                    modifier = Modifier
                                        .size(50.dp)
                                        .clip(shape = CircleShape)
                                )
                            }
                            Text(
                                text = "  Facebook",
                                style = TextStyle(),
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Normal,
                                fontFamily = FontFamily.SansSerif,
                                color = Color.White
                            )
                        }
                        Text(
                            text = "                Mike Mike",
                            style = TextStyle(),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.White
                        )
                    }
                }
            }

            Divider(color = Color.Gray, modifier = Modifier.width(340.dp))

            if (isEditing) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(
                        onClick = {
                            isEditing = false
                            newName = name // Reset newName to the original name
                        }
                    ) {
                        Text("Cancel")
                    }
                    TextButton(
                        onClick = {
                            isEditing = false
                            name = newName // Update the original name with the new name
                        }
                    ) {
                        Text("Save")
                    }
                }
            }

            Row(
                modifier = Modifier
                    .height(75.dp)
                    .clickable { isEditing = !isEditing }
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(25.dp))

                if (isEditing) {
                    OutlinedTextField(
                        value = newName,
                        onValueChange = { newName = it },
                        label = { Text("Edit Name") },
                        modifier = Modifier.fillMaxWidth()
                    )
                } else {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(75.dp),
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .background(
                                        Color(0xff008DDA),
                                        shape = RoundedCornerShape(20.dp)
                                    )
                                    .size(50.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(painter = painterResource(id = R.drawable.x), contentDescription = "x",
                                    modifier = Modifier
                                        .size(50.dp)
                                        .clip(shape = CircleShape)
                                )
                            }
                            Text(
                                text = "  X(Twitter)",
                                style = TextStyle(),
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Normal,
                                fontFamily = FontFamily.SansSerif,
                                color = Color.White
                            )
                        }
                        Text(
                            text = "                mikesplore",
                            style = TextStyle(),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.White
                        )
                    }
                }
            }

            Divider(color = Color.Gray, modifier = Modifier.width(340.dp))

            if (isEditing) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(
                        onClick = {
                            isEditing = false
                            newName = name // Reset newName to the original name
                        }
                    ) {
                        Text("Cancel")
                    }
                    TextButton(
                        onClick = {
                            isEditing = false
                            name = newName // Update the original name with the new name
                        }
                    ) {
                        Text("Save")
                    }
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