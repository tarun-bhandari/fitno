package com.tarunbhandari.fitno.util

sealed class Screen(val route: String) {
    object OnBoarding: Screen("onboarding")
    object Login: Screen("onboarding")
    object Home: Screen("home")
}