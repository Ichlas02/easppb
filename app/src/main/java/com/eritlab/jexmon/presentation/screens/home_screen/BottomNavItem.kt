package com.eritlab.jexmon.presentation.screens.home_screen

import com.eritlab.jexmon.R
import com.eritlab.jexmon.presentation.graphs.home_graph.ShopHomeScreen

sealed class BottomNavItem(val title: String, val icon: Int, val route: String) {
    object HomeNav : BottomNavItem(
        title = "Home",
        icon = R.drawable.home,
        route = ShopHomeScreen.DashboardScreen.route
    )

    object MyStoreNav : BottomNavItem(
        title = "My Store",
        icon = R.drawable.shop_icon,
        route = ShopHomeScreen.FavouriteScreen.route
    )

    object ProfileNav : BottomNavItem(
        title = "Profile",
        icon = R.drawable.user_icon,
        route = ShopHomeScreen.ProfileScreen.route
    )
}
