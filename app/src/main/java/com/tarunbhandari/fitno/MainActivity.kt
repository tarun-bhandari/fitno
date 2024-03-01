package com.tarunbhandari.fitno

/*
    @Author Tarun Bhandari
    github: https://github.com/tarun-bhandari/
 */

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.tarunbhandari.fitno.ui.screen.Home.HomeScreen
import com.tarunbhandari.fitno.ui.theme.FitnoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
//         For the edge to edge
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT),
            navigationBarStyle = SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT)
        )
        super.onCreate(savedInstanceState)
        setContent {
            FitnoTheme {
                HomeScreen()
            }
        }
    }
}

