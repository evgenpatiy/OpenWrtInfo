package com.example.openwrtinfo.ui.screens.routers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.openwrtinfo.ui.components.appbar.AppBar
import com.example.openwrtinfo.ui.previews.AllScreenPreview
import com.example.openwrtinfo.ui.theme.OpenWrtInfoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoutersScreen(
    drawerState: DrawerState,
) {
    Scaffold(
        topBar = {
            AppBar(
                drawerState = drawerState,
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Routers")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@AllScreenPreview
@Composable
fun RoutersScreenPreview() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    OpenWrtInfoTheme {
        RoutersScreen(drawerState)
    }
}