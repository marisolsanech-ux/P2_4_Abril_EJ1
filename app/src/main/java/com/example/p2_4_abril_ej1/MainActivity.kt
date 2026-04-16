package com.example.p2_4_abril_ej1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.p2_4_abril_ej1.navigation.AppNavigation
import com.example.p2_4_abril_ej1.ui.theme.P2_4_Abril_EJ1Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            P2_4_Abril_EJ1Theme {
                AppNavigation()
            }
        }
    }
}