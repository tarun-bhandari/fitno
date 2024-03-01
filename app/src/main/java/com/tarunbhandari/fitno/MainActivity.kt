package com.tarunbhandari.fitno

/*
    @Author Tarun Bhandari
    github: https://github.com/tarun-bhandari/
 */

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.tarunbhandari.fitno.ui.theme.FitnoTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitnoTheme {

            }
        }
    }
}

