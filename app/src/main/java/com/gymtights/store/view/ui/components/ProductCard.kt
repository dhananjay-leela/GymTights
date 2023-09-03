package com.gymtights.store.view.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.gymtights.store.R
import com.gymtights.store.view.ui.theme.GymTightsTheme

@Composable
fun ProductCard(
    imageUrl: String,
    title: String,
    color: String,
    price: Int,
    label: String?,
    onProductClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(4.dp)
            .clickable {
                onProductClicked()
            }
    ) {
        Box(
            modifier = Modifier
                .aspectRatio(0.8f)
                .background(Color.White)
        ) {
            AsyncImage(
                modifier = Modifier
                    .align(Alignment.Center),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .decoderFactory(SvgDecoder.Factory())
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_loading),
                contentDescription = stringResource(id = R.string.product_image),
                contentScale = ContentScale.FillBounds,
                error = painterResource(R.drawable.ic_image_not_found)
            )

            if (label != null) {
                Text(
                    modifier = Modifier
                        .padding(vertical = 6.dp)
                        .border(width = 1.dp, color = Color.Black)
                        .background(Color.LightGray)
                        .align(Alignment.BottomStart)
                        .padding(horizontal = 4.dp),
                    color = Color.Black,
                    text = label,
                    fontSize = 14.sp
                )
            }
        }

        Text(
            modifier = Modifier
                .padding(bottom = 4.dp)
                .align(Alignment.Start),
            text = title,
            fontSize = 14.sp, color = Color.Black
        )

        Text(
            modifier = Modifier
                .padding(bottom = 4.dp)
                .align(Alignment.Start),
            text = color,
            fontSize = 14.sp, color = Color.Black
        )

        Text(
            modifier = Modifier
                .padding(bottom = 4.dp)
                .align(Alignment.Start),
            text = "£ $price",
            fontSize = 14.sp, color = Color.Black
        )
    }
}

@Composable
@Preview(name = "Product Card Preview")
private fun ProductCardPreview() {
    GymTightsTheme {
        ProductCard(imageUrl = "", title = "EveryDay Seamless Leggings", color = "Black", price = 23, label = "New") { }
    }
}