package com.example.unitconverterapp.composables.converter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResultBlock(inputMessage : String, resultMessage : String, modifier : Modifier = Modifier){

    Card(
        elevation = CardDefaults.cardElevation(20.dp),
        modifier = modifier.padding(0.dp, 20.dp, 0.dp ,0.dp)
    //colors = CardDefaults.cardColors(containerColor =  Color.Transparent)
    ) {

        Column(
            modifier = modifier.padding(20.dp)
        ) {
            Text(
                text = inputMessage,
                //modifier = modifier .padding(0.dp, 5.dp, 0.dp, 5.dp),
                fontSize = 28.sp
                )
            Text(
                text = resultMessage,
                //modifier = modifier.padding(0.dp, 5.dp, 0.dp, 5.dp),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }

    }

}