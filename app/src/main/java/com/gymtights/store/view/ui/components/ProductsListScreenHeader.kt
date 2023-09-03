package com.gymtights.store.view.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.gymtights.store.R
import com.gymtights.store.view.ui.theme.GymTightsTheme
import java.util.Locale

@Composable
fun ProductScreenHeader(modifier: Modifier = Modifier) {
    Column(modifier = modifier.background(Color.White)) {
        Text(
            text = stringResource(id = R.string.app_name).uppercase(Locale.getDefault()),
            fontSize = 24.sp,
            color = Color.Black,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
@Preview(name = "Product Screen Header Preview")
private fun ProductScreenHeaderPreview() {
    GymTightsTheme {
        ProductScreenHeader()
    }
}