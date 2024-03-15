package com.mike.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.twotone.ArrowBack
import androidx.compose.material.icons.twotone.Build
import androidx.compose.material.icons.twotone.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Sidemenu(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(imageVector = Icons.TwoTone.ExitToApp, contentDescription = "content")

    }

}



@Preview
@Composable
fun SidemenuPreview(){
    Sidemenu()

}