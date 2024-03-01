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
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tarunbhandari.fitno.ui.screen.Home.HomeScreen
import com.tarunbhandari.fitno.ui.screen.onboarding.OnBoardingScreen
import com.tarunbhandari.fitno.ui.theme.FitnoTheme
import com.tarunbhandari.fitno.util.Screen
import com.tarunbhandari.fitno.util.SharedPreferenceHelper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject lateinit var sharedPreferenceHelper: SharedPreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
//         For the edge to edge
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT),
            navigationBarStyle = SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT)
        )

        super.onCreate(savedInstanceState)
        setContent {
            FitnoTheme {
                val navController = rememberNavController()
                MyAppNavGraph(navController,sharedPreferenceHelper)
                if(sharedPreferenceHelper.isFirstTime) {
                    OnBoardingScreen(navController, sharedPreferenceHelper)
                } else {
                    HomeScreen()
                }
            }
        }
    }
}


@Composable
fun MyAppNavGraph(navController: NavHostController, sharedPreferenceHelper: SharedPreferenceHelper) {
    NavHost(navController = navController, startDestination = Screen.OnBoarding.route) {
        composable(Screen.OnBoarding.route) {
            OnBoardingScreen(navController,sharedPreferenceHelper)
        }
        composable(Screen.Home.route) {
            HomeScreen()
        }

    }
}
