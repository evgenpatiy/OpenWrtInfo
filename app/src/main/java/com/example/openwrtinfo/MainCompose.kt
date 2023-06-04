package com.example.openwrtinfo

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.openwrtinfo.ui.components.appdrawer.AppDrawerContent
import com.example.openwrtinfo.ui.components.appdrawer.AppDrawerItemInfo
import com.example.openwrtinfo.ui.theme.OpenWrtInfoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainCompose(
    navController: NavHostController = rememberNavController(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    // vm: IntroViewModel = hiltViewModel()
) {
    OpenWrtInfoTheme {
        Surface {
            ModalNavigationDrawer(
                drawerState = drawerState,
                drawerContent = {
                    AppDrawerContent(
                        drawerState = drawerState,
                        menuItems = DrawerParams.drawerButtons,
                        defaultPick = MainNavOption.RoutersScreen
                    ) { onUserPickedOption ->
                        when (onUserPickedOption) {
                            MainNavOption.RoutersScreen -> {
                                navController.navigate(onUserPickedOption.name) {
                                    popUpTo(NavRoutes.MainRoute.name)
                                }
                            }

                            MainNavOption.SettingsScreen -> {
                                navController.navigate(onUserPickedOption.name) {
                                    popUpTo(NavRoutes.MainRoute.name)
                                }
                            }

                            MainNavOption.AboutScreen -> {
                                navController.navigate(onUserPickedOption.name) {
                                    popUpTo(NavRoutes.MainRoute.name)
                                }
                            }
                        }
                    }
                }
            ) {
                // val isOnboarded = vm.isOnboarded.collectAsState()
                NavHost(
                    navController,
                    startDestination = NavRoutes.MainRoute.name
                ) {
                    // introGraph(navController)
                    mainGraph(drawerState)
                }
            }
        }
    }
}

enum class NavRoutes {
    IntroRoute,
    MainRoute,
}

object DrawerParams {
    val drawerButtons = arrayListOf(
        AppDrawerItemInfo(
            MainNavOption.RoutersScreen,
            R.string.drawer_item_routers,
            R.drawable.ic_router,
            R.string.drawer_item__description_routers
        ),
        AppDrawerItemInfo(
            MainNavOption.SettingsScreen,
            R.string.drawer_item_settings,
            R.drawable.ic_settings,
            R.string.drawer_item__description_settings
        ),
        AppDrawerItemInfo(
            MainNavOption.AboutScreen,
            R.string.drawer_item_about,
            R.drawable.ic_about,
            R.string.drawer_item__description_about
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MainActivityPreview() {
    MainCompose()
}