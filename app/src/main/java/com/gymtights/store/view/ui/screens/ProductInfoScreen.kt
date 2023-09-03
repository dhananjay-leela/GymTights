package com.gymtights.store.view.ui.screens

import android.text.Html
import android.text.Html.FROM_HTML_MODE_COMPACT
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.toSpanned
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.gymtights.store.R
import com.gymtights.store.data.model.Product
import com.gymtights.store.view.ui.components.ProductInfoScreenHeader
import com.gymtights.store.view.ui.components.ProductSize
import com.gymtights.store.view.ui.theme.GymTightsTheme

@Composable
fun ProductInfoScreen(product: List<Product>, onClick: () -> Unit) {
    var selectedProduct by remember { mutableIntStateOf(0) }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .background(Color.White)
            .padding(horizontal = 10.dp)
    ) {
        ProductInfoScreenHeader(title = product[selectedProduct].title) { onClick() }

        //Image Component
        if (product.isNotEmpty()) {
            ImageCarousel(product, selectedProduct) {
                selectedProduct = it
            }
        }

        //Price Component
        PriceComponent(product, selectedProduct)

        //Size Component
        ProductSize(product, selectedProduct)

        //Description Component
        DisplayHtmlContent(product[selectedProduct].description)
    }
}

@Composable
private fun ImageCarousel(product: List<Product>, selectedProduct: Int, onClick: (Int) -> Unit) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(product[selectedProduct].media.size) { index ->
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth(),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product[selectedProduct].media[index].src)
                    .decoderFactory(SvgDecoder.Factory())
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_loading),
                contentDescription = stringResource(id = R.string.product_image),
                contentScale = ContentScale.Fit,
                error = painterResource(R.drawable.ic_image_not_found)
            )
        }
    }
    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        items(product.size) { index ->
            AsyncImage(
                modifier = Modifier
                    .height(100.dp)
                    .border(
                        width = if (index == selectedProduct) 2.dp else 0.dp,
                        color = Color.Gray
                    )
                    .clickable {
                        onClick(index)
                    },
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product[index].featuredMedia.src)
                    .decoderFactory(SvgDecoder.Factory())
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.Fit,
                contentDescription = stringResource(id = R.string.product_image),
                error = painterResource(R.drawable.ic_image_not_found),
                placeholder = painterResource(R.drawable.ic_loading)
            )
        }
    }
}

@Composable
private fun PriceComponent(product: List<Product>, colorVariantIndex: Int) {
    Column(
        modifier = Modifier
            .padding(vertical = 16.dp)
    ) {
        Row(modifier = Modifier.padding(vertical = 6.dp)) {
            val labels = product[colorVariantIndex].labels
            if (!labels.isNullOrEmpty()) {
                labels.forEach {
                    Text(
                        modifier = Modifier
                            .padding(end = 6.dp)
                            .background(Color.LightGray)
                            .padding(horizontal = 8.dp),
                        color = Color.Black,
                        text = it
                    )
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = product[colorVariantIndex].title,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(fontWeight = FontWeight.Black, text = "£ ${product[colorVariantIndex].price}")
        }
        Text(color = Color.Gray, text = product[colorVariantIndex].colour)
    }
}


@Composable
private fun DisplayHtmlContent(htmlContent: String) {
    val spanned = Html.fromHtml(htmlContent, FROM_HTML_MODE_COMPACT).toSpanned()
    val annotatedString = AnnotatedString.Builder().apply {
        append(spanned)
    }.toAnnotatedString()

    Text(
        modifier = Modifier.padding(vertical = 6.dp),
        text = "Description",
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    )
    Text(modifier = Modifier, text = annotatedString)
}

@Composable
@Preview(name = "Product Info Preview")
private fun ProductInfoPreview() {
    GymTightsTheme {
//        ProductInfoScreen()
    }
}