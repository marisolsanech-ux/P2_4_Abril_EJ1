package com.example.p2_4_abril_ej1.screens

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.p2_4_abril_ej1.data.componentList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentDetailScreen(
    navController: NavController,
    componentId: String
) {

    val component = componentList.find { it.id == componentId }

    var showDialog by remember { mutableStateOf(false) }
    var showSheet by remember { mutableStateOf(false) }

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(component?.name ?: "Detalle")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Volver"
                        )
                    }
                }
            )
        }

    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {

            Text(
                text = component?.description ?: "",
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(20.dp))

            when (componentId) {

                "appbars" -> {

                    TopAppBar(
                        title = { Text("Top App Bar") }
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    BottomAppBar {
                        Text(
                            "Bottom App Bar",
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }

                "badges" -> {

                    BadgedBox(
                        badge = {
                            Badge {
                                Text("8")
                            }
                        }
                    ) {
                        Icon(
                            Icons.Default.Notifications,
                            contentDescription = ""
                        )
                    }
                }

                "bottomsheet" -> {

                    Button(
                        onClick = {
                            showSheet = true
                        }
                    ) {
                        Text("Abrir Bottom Sheet")
                    }

                    if (showSheet) {

                        ModalBottomSheet(
                            onDismissRequest = {
                                showSheet = false
                            }
                        ) {
                            Text(
                                "Contenido del Bottom Sheet",
                                modifier = Modifier.padding(20.dp)
                            )
                        }
                    }
                }

                "buttons" -> {

                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {

                        Button(onClick = {}) {
                            Text("Button")
                        }

                        OutlinedButton(onClick = {}) {
                            Text("Outlined Button")
                        }

                        IconButton(onClick = {}) {
                            Icon(Icons.Default.Add, "")
                        }

                        FloatingActionButton(onClick = {}) {
                            Icon(Icons.Default.Add, "")
                        }
                    }
                }

                "card" -> {

                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text("Título Card")
                            Text("Contenido de ejemplo")
                        }
                    }
                }

                "carousel" -> {

                    Row(
                        modifier = Modifier.horizontalScroll(
                            rememberScrollState()
                        ),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {

                        repeat(3) {

                            Card(
                                modifier = Modifier
                                    .size(120.dp)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = androidx.compose.ui.Alignment.Center
                                ) {
                                    Text("Item ${it + 1}")
                                }
                            }
                        }
                    }
                }

                "chip" -> {

                    var selected1 by remember { mutableStateOf(false) }
                    var selected2 by remember { mutableStateOf(false) }
                    var selected3 by remember { mutableStateOf(false) }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {

                        FilterChip(
                            selected = selected1,
                            onClick = {
                                selected1 = !selected1
                            },
                            label = {
                                Text("Chip 1")
                            }
                        )

                        FilterChip(
                            selected = selected2,
                            onClick = {
                                selected2 = !selected2
                            },
                            label = {
                                Text("Chip 2")
                            }
                        )

                        FilterChip(
                            selected = selected3,
                            onClick = {
                                selected3 = !selected3
                            },
                            label = {
                                Text("Chip 3")
                            }
                        )
                    }
                }

                "dialog" -> {

                    Button(
                        onClick = {
                            showDialog = true
                        }
                    ) {
                        Text("Mostrar Dialog")
                    }

                    if (showDialog) {

                        AlertDialog(
                            onDismissRequest = {
                                showDialog = false
                            },
                            title = {
                                Text("Confirmación")
                            },
                            text = {
                                Text("¿Deseas continuar?")
                            },
                            confirmButton = {
                                TextButton(
                                    onClick = {
                                        showDialog = false
                                    }
                                ) {
                                    Text("Sí")
                                }
                            },
                            dismissButton = {
                                TextButton(
                                    onClick = {
                                        showDialog = false
                                    }
                                ) {
                                    Text("No")
                                }
                            }
                        )
                    }
                }

                else -> {
                    Text("Sin vista previa")
                }
            }
        }
    }
}