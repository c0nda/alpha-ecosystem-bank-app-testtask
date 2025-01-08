package com.listener.bankapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.listener.bankapp.DI
import com.listener.bankapp.presentation.daggerViewModel
import com.listener.bankapp.presentation.searchscreen.SearchScreenViewModel
import com.listener.bankapp.presentation.searchscreen.layout.SearchScreen

@Composable
fun BinNavHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Routes.SearchScreen.route) {
        composable(route = Routes.SearchScreen.route) {
            val searchScreenViewModel = daggerViewModel {
                DI.appComponent.viewModelFactory().create(SearchScreenViewModel::class.java)
            }
            SearchScreen(searchScreenViewModel = searchScreenViewModel)
        }
        composable(route = Routes.RequestHistoryScreen.route) {

        }
    }
}