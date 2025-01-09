package com.listener.bankapp.presentation.requesthistotyscreen.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.listener.bankapp.R
import com.listener.bankapp.presentation.item.RequestErrorItem
import com.listener.bankapp.presentation.item.RequestSuccessItem
import com.listener.bankapp.presentation.navigation.Routes
import com.listener.bankapp.presentation.requesthistotyscreen.RequestHistoryViewModel

@Composable
fun RequestHistoryScreen(
    requestHistoryViewModel: RequestHistoryViewModel,
    navController: NavHostController
) {
    val historyState = requestHistoryViewModel.history.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 12.dp, end = 12.dp, top = 20.dp, bottom = 30.dp)
    ) {
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    navController.navigate(Routes.SearchScreen.route) {
                        popUpTo(Routes.RequestHistoryScreen.route) {
                            inclusive = true
                        }
                    }
                }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = null)
                }
                Text(
                    fontWeight = FontWeight.Bold,
                    text = stringResource(id = R.string.request_history)
                )
            }
        }

        items(historyState.value.reversed()) { request ->
            Column {
                Text(
                    modifier = Modifier.padding(bottom = 4.dp),
                    text = request.bin.toString(),
                    fontWeight = FontWeight.Bold
                )
                if (request.errorMessage == null) {
                    request.bankCard?.let { RequestSuccessItem(bankCardInfo = it) }
                } else {
                    RequestErrorItem(errorText = request.errorMessage)
                }
                HorizontalDivider(thickness = 3.dp)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}