package com.example.ardemo


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.ardemo.navigation.ARScreen
import com.example.ardemo.navigation.HomeScreen
import com.example.ardemo.navigation.ProfileScreen
import com.example.ardemo.navigation.ProtoScreen
import com.example.ardemo.screen.ARScreen
import com.example.ardemo.screen.HomeScreen
import com.example.ardemo.screen.ProfileScreen
import com.example.ardemo.screen.ProtoScreen
import com.example.ardemo.ui.theme.ARDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ARDemoTheme {
                val navController = rememberNavController()
                NavHost(navController = navController,
                    startDestination = HomeScreen,){
                    composable<HomeScreen>{
                        HomeScreen(navController)
                    }
                    composable<ARScreen>{
                       val proto = it.toRoute<ARScreen>().model
                        ARScreen(navController, proto)
                    }
                    composable<ProtoScreen>{
                        ProtoScreen(navController)
                    }
                    composable<ProfileScreen>{
                        ProfileScreen()
                    }

                }
            }
        }
    }
}