package com.example.unitconverterapp.composables.converter

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableDoubleState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import com.example.unitconverterapp.data.Conversion
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun TopScreen(
    conversionList : List<Conversion>,
    selectedConversion : MutableState<Conversion?>,
    inputText : MutableState<String>,
    inputVal : MutableDoubleState,
    isLandscape : Boolean,
    localFocus: FocusManager = LocalFocusManager.current,
    save : (String, String) -> Unit
)
{
    var toSave by remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        ConversionMenu(conversionList = conversionList, isLandscape){
            selectedConversion.value = it
            inputVal.doubleValue = 0.0
        }

        selectedConversion.value?.let {
            InputBlock(conversion = it, inputText = inputText, isLandscape){ input ->
                localFocus.clearFocus(true)
                inputVal.doubleValue = input.toDouble()
                toSave = true
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
                if (toSave) {
                    save(message1, message2)
                    toSave = false
                }
                ResultBlock(message1, message2, isLandscape)
            }
        }
    }
}