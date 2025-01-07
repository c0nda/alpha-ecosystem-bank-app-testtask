package com.listener.bankapp.presentation.searchscreen.layout

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.listener.bankapp.R
import com.listener.bankapp.domain.models.BankCard
import com.listener.bankapp.presentation.searchscreen.SearchScreenViewModel
import com.listener.bankapp.utils.Request

@Composable
fun SearchScreen(
    searchScreenViewModel: SearchScreenViewModel
) {
    var bin by rememberSaveable {
        mutableStateOf("")
    }

    val bankCardInfo = searchScreenViewModel.bankCardInfo.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(start = 8.dp, end = 8.dp)
    ) {
        OutlinedTextField(
            value = bin,
            onValueChange = {
                if (it.length <= 8 && it.matches(Regex("\\d*"))) {
                    bin = it
                }
            },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .height(80.dp)
                .fillMaxWidth()
                .padding(top = 30.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                cursorColor = Color.Black
            ),
            textStyle = TextStyle.Default.copy(fontSize = 14.sp),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        TextButton(
            modifier = Modifier.padding(top = 5.dp),
            onClick = {
                if (bin.length >= 6) {
                    searchScreenViewModel.getBankCardInfoByBin(bin.toLong())
                }
            },
            shape = RoundedCornerShape(20.dp),
            colors = ButtonColors(
                containerColor = Color.Black,
                contentColor = Color.White,
                disabledContentColor = Color.White,
                disabledContainerColor = Color.Black
            )
        ) {
            Text(
                text = stringResource(id = R.string.find),
                modifier = Modifier.padding(4.dp),
                fontSize = 16.sp
            )
        }

        when (bankCardInfo.value) {
            is Request.Success -> {

            }

            is Request.Loading -> {
                CircularProgressIndicator()
            }

            is Request.Error -> {
                val errorText =
                    (bankCardInfo.value as Request.Error<BankCard>).error?.message.toString()
                Log.e(
                    "request_error",
                    errorText
                )
                Text(text = "${stringResource(id = R.string.error)}: $errorText")
            }
        }
    }
}