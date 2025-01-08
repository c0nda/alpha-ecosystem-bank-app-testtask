package com.listener.bankapp.presentation.item

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.listener.bankapp.R

@Composable
fun RequestErrorItem(
    modifier: Modifier = Modifier,
    errorText: String
) {
    Text(text = "${stringResource(id = R.string.error)}: $errorText")
}