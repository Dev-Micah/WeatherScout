package com.micahnyabuto.weatherscout.composables

import android.widget.ProgressBar
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.micahnyabuto.weatherscout.R


@Composable
fun ProgressBar(){
    CircularProgressIndicator(
        modifier = Modifier
            .size(34.dp)
            .fillMaxWidth(),//Use size instead of width
        color = colorResource(id = R.color.teal_200),


    )
}