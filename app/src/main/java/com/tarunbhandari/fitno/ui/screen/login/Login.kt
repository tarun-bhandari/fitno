package com.tarunbhandari.fitno.ui.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tarunbhandari.fitno.ui.theme.FitnoTheme

@Composable
fun LoginScreen() {
/*
    ToDo: A view model for handling the state of the variable and validating the information and saving it to database
    ToDo: And navigate it to the next screen
 */

//    to check if there is an error or not
    var errorInName by remember { mutableStateOf(false) }
    var errorInAge by remember { mutableStateOf(false) }
    var errorInGender by remember { mutableStateOf(false) }
    var errorInWeight by remember { mutableStateOf(false) }

//    state for the switch
    var isMaleSelect by remember { mutableStateOf(false) }
    var isFemaleSelect by remember { mutableStateOf(false) }

    val viewmodel: LoginViewModel = viewModel()

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Filled the form",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            isError = errorInName,
            label = {
                Text(
                    text = "Enter your name",
                    fontWeight = FontWeight.Medium
                )
            },
            supportingText = {
                (if (errorInName) viewmodel.validateNameField() else "*required")?.let {
                    Text(
                        text = it
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = {
                Text(text = "Enter your age")
            },
            supportingText = {
                (if (errorInAge) viewmodel.validateAgeField() else "*required")?.let {
                    Text(
                        text = it
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            )
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = {
                Text(text = "Enter your weight")
            }
        )
        Text(
            text = "Gender",
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp, vertical = 8.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Male",
                modifier = Modifier.padding(horizontal = 12.dp)
            )
            Switch(
                checked = isMaleSelect,
                onCheckedChange = {
                    isMaleSelect = true
                    if(isMaleSelect) viewmodel.gender = "Male" else viewmodel.gender = ""
                },
                modifier = Modifier.padding(horizontal = 4.dp)
            )
            Text(
                text = "Female",
                modifier = Modifier.padding( horizontal = 12.dp))
            Switch(
                checked = isFemaleSelect,
                onCheckedChange = {
                    isFemaleSelect = true
                    if(isFemaleSelect) viewmodel.gender = "Female" else viewmodel.gender = ""
                }
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 24.dp)
        ) {
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Cancel")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Next")
            }
        }
    }
}

@Composable
fun UserAccountScreen() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .border(shape = MaterialTheme.shapes.small, color = Color.Black, width = 3.dp)
            .padding(16.dp)
    ) {
        Image(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "User Icon",
            contentScale = ContentScale.Fit
        )
        Text(
            text = "Tarun Bhandari",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
    }
}


@Composable
@Preview(
    showSystemUi = true,
    showBackground = true,
    name = "Login"
)
fun LoginScreenPreview() {
    FitnoTheme {
        LoginScreen()
    }
}

@Composable
@Preview(
    showBackground = true,
    name = "Already login user account"
)
fun UserAccountScreenPreview() {
    FitnoTheme {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            UserAccountScreen()
            UserAccountScreen()
            UserAccountScreen()
        }
    }
}
