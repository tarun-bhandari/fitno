package com.tarunbhandari.fitno.ui.screen.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class LoginViewModel: ViewModel() {

    var age = mutableStateOf(0)
    var name = mutableStateOf("")
    var weight = mutableStateOf("")
    var gender = mutableStateOf("")


}

