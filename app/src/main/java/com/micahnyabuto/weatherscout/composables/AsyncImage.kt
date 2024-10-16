package com.micahnyabuto.weatherscout.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.micahnyabuto.weatherscout.R

@Composable
fun loadImage(url: String, dp: Dp,modifier: Modifier){
    AsyncImage(model = ImageRequest.Builder(LocalContext.current)
        .data(url)
        .crossfade(true)
        .build(),
        contentDescription ="Image" ,
        modifier = modifier
            .size(dp)
            .background(color = colorResource(id = R.color.transparent)),
        contentScale = ContentScale.FillBounds
    )
}