package com.micahnyabuto.weatherscout.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.micahnyabuto.weatherscout.Model.forecast.ModelWeatherForecastResponse
import com.micahnyabuto.weatherscout.R

@Composable
fun ForecastWeatherDataSunMoon(data: ModelWeatherForecastResponse){
    Column {
       Row(
           modifier = Modifier
               .fillMaxSize()
               .padding(horizontal = 15.dp)
               .background(
                   color = colorResource(id = R.color.bg),
                   shape = RoundedCornerShape(20.dp)
               ),
           verticalAlignment = Alignment.CenterVertically ,
           horizontalArrangement = Arrangement.Center
       ) {
           element(
               R.drawable.sunrise,"Sunset",
           )
       }
    }

}