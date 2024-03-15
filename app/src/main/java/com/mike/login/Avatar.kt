package com.mike.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Avatars(){
    Column(modifier = Modifier
        .background(Color.Black)
        .fillMaxSize()) {
        Column(modifier = Modifier
            .height(750.dp)
            .background(Color.White, shape = RoundedCornerShape(60.dp,0.dp))
            .fillMaxWidth()) {

        }


    }
}

@Preview
@Composable
fun AvatarsPreview(){
Avatars()
}