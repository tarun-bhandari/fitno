package com.tarunbhandari.fitno.ui.screen.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tarunbhandari.fitno.ui.theme.FitnoTheme

@Composable
fun LoginScreen() {
/*
    ToDo: A view model for handling the state of the variable and validating the information and saving it to database
    ToDo: And navigate it to the next screen
 */

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
            label = {
                Text(text = "Enter your name")
            }
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = {
                Text(text = "Enter your age")
            }
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
                checked = false,
                onCheckedChange = {},
                modifier = Modifier.padding(horizontal = 4.dp)
            )
            Text(
                text = "Female",
                modifier = Modifier.padding( horizontal = 12.dp))
            Switch(
                checked = false,
                onCheckedChange = {},
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
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

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
    showSystemUi = true,
    showBackground = true,
    name = "Already login user account"
)
fun UserAccountScreenPreview() {
    FitnoTheme {
        UserAccountScreen()
    }
}
