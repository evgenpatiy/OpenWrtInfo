package com.example.openwrtinfo

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.openwrtinfo.ui.screens.about.AboutScreen
import com.example.openwrtinfo.ui.screens.routers.RoutersScreen
import com.example.openwrtinfo.ui.screens.settings.SettingsScreen

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.mainGraph(drawerState: DrawerState) {
    navigation(
        startDestination = MainNavOption.RoutersScreen.name,
        route = NavRoutes.MainRoute.name
    ) {

        composable(MainNavOption.RoutersScreen.name) {
            RoutersScreen(drawerState)
        }
        composable(MainNavOption.SettingsScreen.name) {
            SettingsScreen(drawerState)
        }
        composable(MainNavOption.AboutScreen.name) {
            AboutScreen(drawerState)
        }
    }
}

enum class MainNavOption {
    RoutersScreen,
    AboutScreen,
    SettingsScreen,
}