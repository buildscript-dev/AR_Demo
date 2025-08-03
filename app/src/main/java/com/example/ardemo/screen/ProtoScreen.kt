package com.example.ardemo.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ardemo.navigation.ARScreen
import kotlin.random.Random

@Composable
fun ProtoScreen(navController: NavController){
val listOfProtos = listOf(
    "Cube",
    "Triangle",
    "Soccer Ball",
    "Cake",
    "Meal",
    "Ironman",
    "Spiderman",
    "Dr Strange",
    "Poke Ball",
    "Pikachu",
    "Charmandal",
    "Vintage Car",
    "Lamborghini ",
    "Warhorn ",
)
//    Column(modifier = Modifier.fillMaxSize()
//        .padding(16.dp)
//        .verticalScroll(rememberScrollState()),
//    verticalArrangement = Arrangement.Center,
//    horizontalAlignment = Alignment.CenterHorizontally){
//        Box(modifier = Modifier.height(60.dp)) {
//            Text(text = "Prototypes", fontSize = 24.sp, modifier = Modifier.align(Alignment.Center))
//        }
//        FlowColumn(
//            modifier = Modifier
//                .fillMaxWidth()
//                .verticalScroll(
//                    state = rememberScrollState()
//                ),
//            verticalArrangement = Arrangement.Center,
//            horizontalArrangement = Arrangement.Center
//        ) {
//            listOfProtos.forEach { proto ->
//                ProtoItem(proto = proto) {
//                    navController.navigate(ARScreen(proto))
//                }
//            }
//        }
//    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.height(100.dp)
            .fillMaxWidth()) {
            Text(
                text = "Prototypes",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = generateRandomLightColor(),
                modifier = Modifier.align(Alignment.Center)
            )
        }

        FlowColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalArrangement = Arrangement.Center
        ) {
            listOfProtos.forEach { proto ->
                ProtoItem(proto = proto) {
                    navController.navigate(ARScreen(proto))
                }
            }
        }
    }


}


@Composable
fun ProtoItem(proto: String, onClick:() -> Unit){
    val color = remember(proto) {
        generateRandomLightColor()
    }
    Box(modifier = Modifier
        .fillMaxWidth(0.8f)
        .height(100.dp)
        .padding(16.dp)
        .clip(RoundedCornerShape(12.dp))
        .background(color)
        .clickable{onClick()}){
        Text(text = proto,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.Center) ) }
    }

fun generateRandomLightColor(): Color {
    val random = Random(System.currentTimeMillis())
    val red = random.nextInt(150, 256)
    val green = random.nextInt(200, 256)
    val blue = random.nextInt(200, 256)
    val color = Color(red, green, blue)
    return color
}