package com.listener.bankapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.listener.bankapp.presentation.navigation.BinNavHost
import com.listener.bankapp.presentation.ui.theme.BankappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BankappTheme {
                BinNavHost(navController = rememberNavController())
            }
        }
    }
}