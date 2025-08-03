package com.example.ardemo.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.ardemo.navigation.ProfileScreen
import com.example.ardemo.navigation.ProtoScreen

@Composable
fun HomeScreen(navController: NavController){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Button(onClick = {navController.navigate(ProtoScreen)}){
            Text("Proto")
        }
        Button(onClick = {navController.navigate(ProfileScreen)}){
            Text("Profile")
        }

    }


}