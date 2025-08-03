package com.example.ardemo.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun AboutScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "AR Placement App (Android)",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionTitle("Requirements")
        SectionBody("• Your device must be running Android 13 (API level 33) or higher.")
        SectionBody("• ARCore must be installed and supported on your device.")

        Spacer(modifier = Modifier.height(16.dp))

        SectionTitle("Dependencies")
        SectionBody("• ARSceneView – for real-world 3D model placement.")
        SectionBody("• Android Navigation Component – for managing navigation between screens.")
        SectionBody("• Kotlin Serialization – for handling data serialization.")

        Spacer(modifier = Modifier.height(16.dp))

        SectionTitle("How to Use")
        SectionBody("1. Launch the app.")
        SectionBody("2. Tap the Play button.")
        SectionBody("3. Select an object to place (e.g., Car, Cube, Pikachu).")
        SectionBody("4. The camera will open. Point your device at a flat surface.")
        SectionBody("5. Hold the device steady while the surface is detected.")
        SectionBody("6. Wait until small white dots appear — this indicates the surface is being scanned.")
        SectionBody("7. Once the surface is confirmed, the object will appear anchored in the environment.")

        Spacer(modifier = Modifier.height(16.dp))

        SectionTitle("Additional Features")
        SectionBody("• About: Opens this screen with detailed information.")
        SectionBody("• Exit: Closes the application.")

        Spacer(modifier = Modifier.height(16.dp))

        SectionTitle("Developer Info")
        SectionBody("Developed by Madara Uchiha")
        SectionBody("This project was built as part of a learning journey to explore AR and Jetpack Compose in Android.")
        SectionBody("Source code and contributions are managed privately but may be shared for educational use.")

        Spacer(modifier = Modifier.height(16.dp))

        SectionTitle("License")
        SectionBody("This app is open for personal and educational use.")
        SectionBody("Please provide credit if you reuse any part of this project.")
    }
}


@Composable
fun SectionTitle(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(bottom = 4.dp)
    )
}

@Composable
fun SectionBody(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.padding(bottom = 4.dp)
    )
}
