package com.tarunbhandari.fitno.ui.screen.login

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tarunbhandari.fitno.data.AppDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val appDatabase: AppDatabase,
    private val context: Context
): ViewModel() {

    var age by mutableStateOf(0)
    var name by mutableStateOf("")
    var weight by mutableStateOf(0.0)
    var gender by mutableStateOf("")


    fun validateNameField(): String? {
        if(name.isNullOrBlank() || name.isEmpty()) {
            return "required field"
        } else if(name.isDigitsOnly()) {
            return "should not contain any number"
        } else {
            return null
        }
    }

    fun validateAgeField(): String? {
        if(age == 0){
            return "required field"
        } else if(age <= 5) {
            return "Age should be greater than 5"
        } else {
            return null
        }
    }

    fun validateGenderField(): String? {
        if(gender.isNullOrBlank() || gender.isEmpty()) {
            return "required field"
        } else {
            return null
        }
    }

}

