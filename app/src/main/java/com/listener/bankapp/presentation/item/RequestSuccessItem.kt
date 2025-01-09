package com.listener.bankapp.presentation.item

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.listener.bankapp.R
import com.listener.bankapp.domain.models.BankCard

@Composable
fun RequestSuccessItem(
    bankCardInfo: BankCard
) {
    val context = LocalContext.current

    Row {
        Column {
            Text(
                text = stringResource(id = R.string.scheme),
                fontWeight = FontWeight.Light
            )
            Text(
                text = bankCardInfo.scheme
                    ?: stringResource(id = R.string.blank)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(id = R.string.brand),
                fontWeight = FontWeight.Light
            )
            Text(
                text = bankCardInfo.brand
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
                        text = (bankCardInfo.number?.length
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
                        text = (bankCardInfo.number?.luhn
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
                    text = (bankCardInfo.bank?.name ?: stringResource(id = R.string.blank)) + ", "
                )
                Text(
                    text = bankCardInfo.bank?.city ?: stringResource(id = R.string.blank)
                )
            }
            TextButton(
                onClick = {
                    if (bankCardInfo.bank?.url != null) {
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("http://${bankCardInfo.bank.url}")
                        ).also { startActivity(context, it, null) }
                    }
                },
                enabled = bankCardInfo.bank?.url != null,
                colors = ButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Blue,
                    disabledContentColor = Color.Black,
                    disabledContainerColor = Color.Transparent
                )
            ) {
                Text(text = bankCardInfo.bank?.url ?: stringResource(id = R.string.blank))
            }
            TextButton(
                onClick = {
                    if (bankCardInfo.bank?.phone != null) {
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("tel:${bankCardInfo.bank.phone}")
                        ).also { startActivity(context, it, null) }
                    }
                },
                enabled = bankCardInfo.bank?.phone != null,
                colors = ButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Blue,
                    disabledContentColor = Color.Black,
                    disabledContainerColor = Color.Transparent
                )
            ) {
                Text(text = bankCardInfo.bank?.phone ?: stringResource(id = R.string.blank))
            }
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = stringResource(id = R.string.type),
                fontWeight = FontWeight.Light
            )
            Text(
                text = bankCardInfo.type ?: stringResource(id = R.string.blank)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(id = R.string.prepaid),
                fontWeight = FontWeight.Light
            )
            Text(
                text = if (bankCardInfo.prepaid != null) {
                    if (bankCardInfo.prepaid == true) {
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
                    text = bankCardInfo.country?.emoji ?: stringResource(id = R.string.blank)
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = bankCardInfo.country?.name ?: stringResource(id = R.string.blank)
                )
            }
            TextButton(
                onClick = {
                    if (bankCardInfo.country?.latitude != null && bankCardInfo.country.longitude != null) {
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("geo:${bankCardInfo.country.latitude}, ${bankCardInfo.country.longitude}")
                        ).also { startActivity(context, it, null) }
                    }
                },
                enabled = bankCardInfo.country?.latitude != null && bankCardInfo.country.longitude != null,
                colors = ButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Blue,
                    disabledContentColor = Color.Black,
                    disabledContainerColor = Color.Transparent
                )
            ) {
                Column {
                    Row {
                        Text(
                            text = "(" + stringResource(id = R.string.latitude) + ": ",
                            fontWeight = FontWeight.Light
                        )
                        Text(
                            text = (bankCardInfo.country?.latitude
                                ?: stringResource(id = R.string.blank)).toString() + ","
                        )
                    }
                    Row {
                        Text(
                            text = stringResource(id = R.string.longitude) + ": ",
                            fontWeight = FontWeight.Light
                        )
                        Text(
                            text = (bankCardInfo.country?.longitude
                                ?: stringResource(id = R.string.blank)).toString() + ")"
                        )
                    }
                }
            }
        }
    }
}