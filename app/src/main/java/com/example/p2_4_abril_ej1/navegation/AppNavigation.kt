package com.example.p2_4_abril_ej1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.p2_4_abril_ej1.screens.ComponentDetailScreen
import com.example.p2_4_abril_ej1.screens.ComponentListScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "list"
    ) {

        composable("list") {
            ComponentListScreen(navController)
        }

        composable(
            route = "detail/{componentId}",
            arguments = listOf(
                navArgument("componentId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->

            val componentId =
                backStackEntry.arguments?.getString("componentId") ?: ""

            ComponentDetailScreen(
                navController = navController,
                componentId = componentId
            )
        }
    }
}