package com.example.p2_4_abril_ej1.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.p2_4_abril_ej1.navigation.AppNavigation
import com.example.p2_4_abril_ej1.ui.theme.P2_4_Abril_EJ1Theme

// IA generated: Main activity that sets up the Compose theme and navigation, moved to activities package per guidelines
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            P2_4_Abril_EJ1Theme {
                // IA generated: Starting the application navigation flow
                AppNavigation()
            }
        }
    }
}
