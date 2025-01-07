package com.listener.bankapp.presentation.navigation

sealed class Routes(val route: String) {
    data object SearchScreen : Routes("search_screen")
    data object RequestHistoryScreen : Routes("history_screen")
}