package com.example.unitconverterapp.composables

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.unitconverterapp.data.Conversion
import com.example.unitconverterapp.data.ConversionResult
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun TopScreen(conversionList : List<Conversion> , save : (String, String) -> Unit){
    val selectedConversion : MutableState<Conversion?> = remember { mutableStateOf(null) }
    val inputText = remember { mutableStateOf("") }
    val inputVal = remember { mutableDoubleStateOf(0.0) }
    

    ConversionMenu(conversionList = conversionList){
        selectedConversion.value = it
        inputVal.doubleValue = 0.0
    }

    selectedConversion.value?.let {
        InputBlock(conversion = it, inputText = inputText){ input ->
            inputVal.doubleValue = input.toDouble()
        }
    }

    if (inputVal.doubleValue != 0.0){
        val result = selectedConversion.value?.multiplyBy?.times(inputVal.doubleValue)

        //Rounding off result to 4 decimal places
        val df = DecimalFormat("#.####")
        df.roundingMode = RoundingMode.DOWN
        val roundedResult = df.format(result)
        Log.i("ROUNDED", roundedResult)

        selectedConversion.value?.let {
            val message1 = "${inputVal.doubleValue} ${selectedConversion.value!!.convertFrom} is equal to"
            val message2 = "$roundedResult ${selectedConversion.value!!.convertTo}"
            save(message1, message2)
            ResultBlock(message1, message2)
        }


    }
}