package com.tarunbhandari.fitno.util

import android.content.SharedPreferences
import javax.inject.Inject

// An helper class for handling the SharedPreference
class SharedPreferenceHelper @Inject constructor(
    private val sharedPreferences: SharedPreferences
){
    companion object {
        private const val SHOWTHEONBOARDINGSCREEN = "isUserFirstTime"
    }


    /*
        This variable will check is the user is first time using the app or not..
     */
    var isFirstTime: Boolean
        get() = sharedPreferences.getBoolean(SHOWTHEONBOARDINGSCREEN, true)
        set(value) = sharedPreferences.edit().putBoolean(SHOWTHEONBOARDINGSCREEN, value).apply()


}
