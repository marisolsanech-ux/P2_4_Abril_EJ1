package com.example.p2_4_abril_ej1.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.p2_4_abril_ej1.data.componentList

// IA generated: Screen that displays a list of Material 3 components
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentListScreen(navController: NavController) {

    Scaffold(

        topBar = {
            // IA generated: Top bar with title and a notification badge
            TopAppBar(
                title = {
                    Text("Componentes M3")
                },
                actions = {
                    BadgedBox(
                        badge = {
                            Badge {
                                Text("3")
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notificaciones"
                        )
                    }
                }
            )
        },

        bottomBar = {
            // IA generated: Bottom navigation bar with basic items
            NavigationBar {

                NavigationBarItem(
                    selected = true,
                    onClick = {},
                    icon = {
                        Icon(Icons.Default.Home, contentDescription = "Inicio")
                    },
                    label = {
                        Text("Inicio")
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(Icons.Default.Notifications, contentDescription = "Alertas")
                    },
                    label = {
                        Text("Alertas")
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(Icons.Default.Person, contentDescription = "Perfil")
                    },
                    label = {
                        Text("Perfil")
                    }
                )
            }
        }

    ) { padding ->

        // IA generated: List using LazyColumn to show items from data source
        LazyColumn(contentPadding = padding) {

            items(componentList) { item ->

                ListItem(
                    headlineContent = {
                        Text(item.name)
                    },

                    supportingContent = {
                        Text(item.subtitle)
                    },

                    trailingContent = {
                        Icon(
                            Icons.Default.ArrowForward,
                            contentDescription = "Ir"
                        )
                    },

                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            // IA generated: Navigate to detail screen passing the item ID
                            navController.navigate("detail/${item.id}")
                        }
                )

                HorizontalDivider()
            }
        }
    }
}
