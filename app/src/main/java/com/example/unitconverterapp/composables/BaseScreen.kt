package com.example.unitconverterapp.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unitconverterapp.ConverterViewModel

@Composable
fun BaseScreen(
    modifier : Modifier = Modifier,
    converterViewModel : ConverterViewModel = viewModel()
){
    val conversionList = converterViewModel.getConversion()
    Column(
        modifier = modifier
            .padding(30.dp)
    ) {
        TopScreen(conversionList)
        Spacer(modifier = modifier.height(20.dp))
        HistoryScreen()
    }
}