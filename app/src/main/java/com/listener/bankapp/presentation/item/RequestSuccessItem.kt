package com.listener.bankapp.presentation.item

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.listener.bankapp.R
import com.listener.bankapp.domain.models.BankCard
import com.listener.bankapp.utils.Request

@Composable
fun RequestItem(
    modifier: Modifier = Modifier,
    bankCardInfo: State<Request<BankCard>>
) {
    Row {
        Column {
            Text(
                text = stringResource(id = R.string.scheme),
                fontWeight = FontWeight.Light
            )
            Text(
                text = (bankCardInfo.value as Request.Success<BankCard>).data.scheme
                    ?: stringResource(id = R.string.blank)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(id = R.string.brand),
                fontWeight = FontWeight.Light
            )
            Text(
                text = (bankCardInfo.value as Request.Success<BankCard>).data.brand
                    ?: stringResource(id = R.string.blank)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(id = R.string.card_number),
                fontWeight = FontWeight.Light
            )

            Row {
                Column {
                    Text(
                        text = stringResource(id = R.string.length),
                        fontWeight = FontWeight.Light,
                        fontSize = 12.sp
                    )
                    Text(
                        text = ((bankCardInfo.value as Request.Success<BankCard>)
                            .data.number?.length
                            ?: stringResource(id = R.string.blank)).toString()
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Column {
                    Text(
                        text = stringResource(id = R.string.luhn),
                        fontWeight = FontWeight.Light,
                        fontSize = 12.sp
                    )
                    Text(
                        text = ((bankCardInfo.value as Request.Success<BankCard>)
                            .data.number?.luhn
                            ?: stringResource(id = R.string.blank)).toString()
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(id = R.string.bank),
                fontWeight = FontWeight.Light
            )
            Row {
                Text(
                    text = ((bankCardInfo.value as Request.Success<BankCard>).data.bank?.name
                        ?: stringResource(id = R.string.blank)) + ", "
                )
                Text(
                    text = (bankCardInfo.value as Request.Success<BankCard>).data.bank?.city
                        ?: stringResource(id = R.string.blank)
                )
            }
            Text(
                text = (bankCardInfo.value as Request.Success<BankCard>).data.bank?.url
                    ?: stringResource(id = R.string.blank)
            )
            Text(
                text = (bankCardInfo.value as Request.Success<BankCard>).data.bank?.phone
                    ?: stringResource(id = R.string.blank)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = stringResource(id = R.string.type),
                fontWeight = FontWeight.Light
            )
            Text(
                text = (bankCardInfo.value as Request.Success<BankCard>).data.type
                    ?: stringResource(id = R.string.blank)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(id = R.string.prepaid),
                fontWeight = FontWeight.Light
            )
            Text(
                text = if ((bankCardInfo.value as Request.Success<BankCard>).data.prepaid != null) {
                    if ((bankCardInfo.value as Request.Success<BankCard>).data.prepaid == true) {
                        stringResource(id = R.string.yes)
                    } else {
                        stringResource(id = R.string.no)
                    }
                } else {
                    stringResource(id = R.string.blank)
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(id = R.string.country),
                fontWeight = FontWeight.Light
            )
            Row {
                Text(
                    text = (bankCardInfo.value as Request.Success<BankCard>).data.country?.emoji
                        ?: stringResource(id = R.string.blank)
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = (bankCardInfo.value as Request.Success<BankCard>).data.country?.name
                        ?: stringResource(id = R.string.blank)
                )
            }
            Row {
                Text(
                    text = "(" + stringResource(id = R.string.latitude) + ": ",
                    fontWeight = FontWeight.Light
                )
                Text(
                    text = ((bankCardInfo.value as Request.Success<BankCard>).data.country?.latitude
                        ?: stringResource(id = R.string.blank)).toString()
                )
                Text(
                    text = ", " + stringResource(id = R.string.longitude) + ": ",
                    fontWeight = FontWeight.Light
                )
                Text(
                    text = ((bankCardInfo.value as Request.Success<BankCard>).data.country?.longitude
                        ?: stringResource(id = R.string.blank)).toString() + ")"
                )
            }
        }
    }
}