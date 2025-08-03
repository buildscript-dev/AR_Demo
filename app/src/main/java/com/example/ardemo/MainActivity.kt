package com.example.ardemo


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.ardemo.navigation.ARScreen
import com.example.ardemo.navigation.AboutScreen
import com.example.ardemo.navigation.HomeScreen
import com.example.ardemo.navigation.ProtoScreen
import com.example.ardemo.screen.ARScreen
import com.example.ardemo.screen.AboutScreen
import com.example.ardemo.screen.HomeScreen
import com.example.ardemo.screen.ProtoScreen
import com.example.ardemo.ui.theme.ARDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ARDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()){ innerPadding ->
                    val navController = rememberNavController()
                    NavHost(navController = navController,
                        startDestination = HomeScreen,
                        modifier = Modifier.padding(innerPadding)){
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
                        composable<AboutScreen>{
                            AboutScreen(navController)
                        }

                    }
                }
            }
        }
    }
}