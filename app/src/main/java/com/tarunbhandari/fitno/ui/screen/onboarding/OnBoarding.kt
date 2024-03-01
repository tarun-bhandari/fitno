package com.tarunbhandari.fitno.ui.screen.onboarding

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.tarunbhandari.fitno.R
import com.tarunbhandari.fitno.ui.theme.FitnoTheme
import com.tarunbhandari.fitno.util.LogTagHelper
import com.tarunbhandari.fitno.util.Screen

@Composable
fun OnBoardingScreen(
    navController: NavHostController
) {
    Log.i(LogTagHelper.SCREEN, "User is on OnBoardingScreen")
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Image(
            painter = painterResource(id = R.drawable.startscreen_img),
            contentDescription = "background image where many people are doing excerise",
            contentScale = ContentScale.Crop
        )
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Text(
                text = "Fitno",
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                color = if(isSystemInDarkTheme()) Color.White else Color.Black
            )
            Spacer(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))
            Text(
                text = "Your's Fitness Friend",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = if(isSystemInDarkTheme()) Color.White else Color.Black
            )
            Spacer(modifier = Modifier.padding( vertical = 24.dp))
            Button(
                onClick = {
                    Log.i(LogTagHelper.CLICK, "User has click on button")
                    navController.navigate(Screen.Home.route)
                    Log.i("Navigation","Navigated to Homescreen")
                          } ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = if(isSystemInDarkTheme()) Color.White else Color.Black
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Let's Get Started")
            }
            Spacer(modifier = Modifier.fillMaxWidth().padding(12.dp))
        }
    }

}

/*
@Composable
@Preview(
    showSystemUi = true
)
fun OnBoardingScreenPreview() {
    FitnoTheme(
        darkTheme = true
    ) {
        OnBoardingScreen()
    }
}
 */

