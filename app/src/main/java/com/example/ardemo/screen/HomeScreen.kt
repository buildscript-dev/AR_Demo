package com.example.ardemo.screen

import android.app.Activity
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ardemo.navigation.AboutScreen
import com.example.ardemo.navigation.ProtoScreen


@Composable
fun HomeScreen(navController: NavController){
    val activity = LocalActivity.current

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {


        Box(
            modifier = Modifier.fillMaxWidth()
                .padding(20.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "AR App",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = generateRandomLightColor()
            )
        }


        Button(
            onClick = { navController.navigate(ProtoScreen) },
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = generateRandomLightColor(),
            ),
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(8.dp)
                .clip(RoundedCornerShape(12.dp))
                .height(60.dp)

        ) {
            Text("Play", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }

        Button(
            onClick = { navController.navigate(AboutScreen) },
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = generateRandomLightColor(),
            ),
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(8.dp)
                .clip(RoundedCornerShape(12.dp))
                .height(60.dp)
        ) {
            Text("About This", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }

        Button(
            onClick = { activity?.finish() },
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = generateRandomLightColor()
            ),
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(8.dp)
                .height(60.dp)
        ) {
            Text("Exit", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }
    }
}

