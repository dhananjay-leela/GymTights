package com.gymtights.store.view.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.material.R

@Composable
fun ProductInfoScreenHeader(title: String, onClick : ()-> Unit) {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Image(
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.CenterStart)
                .clickable { onClick() },
            painter = painterResource(id = R.drawable.material_ic_keyboard_arrow_left_black_24dp),
            contentDescription = ""
        )
        Text(
            modifier = Modifier.align(Alignment.Center),
            fontSize = 20.sp,
            color = Color.Black,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Medium,
            text = title
        )
    }
}
