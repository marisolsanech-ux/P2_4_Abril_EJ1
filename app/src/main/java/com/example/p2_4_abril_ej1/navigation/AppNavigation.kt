package com.example.p2_4_abril_ej1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.p2_4_abril_ej1.screens.ComponentDetailScreen
import com.example.p2_4_abril_ej1.screens.ComponentListScreen

// IA generated: Main navigation configuration for the app
@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    // IA generated: Setting up NavHost with list as start destination
    NavHost(
        navController = navController,
        startDestination = "list"
    ) {

        composable("list") {
            // IA generated: Route for the components list
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

            // IA generated: Route for the component detail, passing ID
            ComponentDetailScreen(
                navController = navController,
                componentId = componentId
            )
        }
    }
}
