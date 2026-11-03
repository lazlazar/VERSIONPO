 package com.example.xstich

 import androidx.compose.ui.unit.sp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.xstich.ui.theme.XStichTheme

import com.example.xstich.ui.theme.Cream
import com.example.xstich.ui.theme.DarkBrown
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
 import com.example.xstich.ui.theme.Lora
 import androidx.compose.foundation.Image
 import androidx.compose.ui.res.painterResource
 import androidx.compose.ui.unit.dp
 import androidx.compose.ui.text.font.FontWeight
 import androidx.compose.foundation.layout.size
 import androidx.compose.foundation.layout.Column
 import androidx.compose.foundation.layout.Arrangement
 import androidx.compose.foundation.layout.width
 import androidx.compose.foundation.layout.padding
 import androidx.compose.ui.text.style.TextAlign

 import androidx.compose.runtime.LaunchedEffect
 import androidx.compose.runtime.mutableStateOf
 import androidx.compose.runtime.remember
 import androidx.compose.runtime.getValue
 import androidx.compose.runtime.setValue
 import kotlinx.coroutines.delay
import androidx.compose.foundation.layout.Row
 import androidx.compose.ui.text.font.FontFamily
 import androidx.compose.material.icons.Icons
 import androidx.compose.material.icons.outlined.Search
 import androidx.compose.material3.Icon
 import androidx.compose.material3.IconButton

 class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            XStichTheme {
                var showSplash by remember { mutableStateOf(true) }

                LaunchedEffect(Unit) {
                    delay(2000)
                    showSplash = false
                }

                if (showSplash) {
                    SplashScreen()
                } else {
                    HomeScreen()
                }
            }
        }
    }
}

 @Composable
 fun SplashScreen(){
     Surface(
         modifier = Modifier.fillMaxSize(),
         color = Cream
     ) {
         Column(
             modifier = Modifier.fillMaxSize(),
             horizontalAlignment = Alignment.CenterHorizontally,
             verticalArrangement = Arrangement.Center
         ){
             Image(
                 painter = painterResource(id = R.drawable.xstitch_logo),
                 contentDescription = "Логотип XStitch" ,
                 modifier = Modifier.size(width = 145.dp, height = 107.dp)
             )

             Text(
                 text = "XStitch",
                 color = DarkBrown,
                 fontSize = 64.sp,
                 fontFamily = Lora,
                 fontWeight = FontWeight.SemiBold
             )

             Text(
                 text = "Маленькие шаги к большим картинам",
                 color = DarkBrown,
                 fontSize = 20.sp,
                 fontFamily = Lora,
                 modifier = Modifier.width(293.dp),
                 textAlign = TextAlign.Center
             )
         }
     }
 }

 @Composable
 fun HomeScreen() {
     Surface(
         modifier = Modifier.fillMaxSize(),
         color = Cream
     ) {
         Column(
             modifier = Modifier
                 .padding(
                     horizontal = 16.dp,
                     vertical = 55.dp
                 )
         ){
             Row(){
                 Text(
                     text = "XStich",
                     fontSize = 36.sp,
                     color = DarkBrown,
                     fontWeight = FontWeight.SemiBold,
                     fontFamily = Lora
                 )

                 IconButton(
                     onClick = {
                         // Поиск добавим позже
                     }
                 ) {
                     Icon(
                         imageVector = Icons.Outlined.Search,
                         contentDescription = "Поиск проектов",
                         tint = DarkBrown
                     )
                 }
             }
         }
     }
 }