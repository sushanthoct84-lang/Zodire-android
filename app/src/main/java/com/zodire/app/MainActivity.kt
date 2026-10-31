

package com.zodire.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Night = Color(0xFF17152B)
private val Violet = Color(0xFF9A78F2)
private val Pink = Color(0xFFFF8EAE)
private val Cream = Color(0xFFFFF7F2)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colorScheme = darkColorScheme(
                primary = Violet,
                secondary = Pink,
                background = Night,
                surface = Night,
                onPrimary = Color.White,
                onBackground = Cream,
                onSurface = Cream
            )) {
                WelcomeScreen()
            }
        }
    }
}

@Composable
private fun WelcomeScreen() {
    Surface(Modifier.fillMaxSize(), color = Night) {
        Column(
            Modifier.fillMaxSize().padding(28.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("✦", color = Pink, fontSize = 54.sp)
            Spacer(Modifier.height(12.dp))
            Text(
                "zodire",
                color = Cream,
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(10.dp))
            Text(
                "A little cosmic. A lot more personal.",
                color = Pink,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(36.dp))
            Column(
                Modifier.fillMaxWidth()
                    .background(Color(0xFF26233F),
                        RoundedCornerShape(20.dp))
                    .padding(22.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Your next chapter starts here",
                    color = Cream,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    "Meet people, discover connections, and explore your astrological compatibility.",
                    color = Color(0xFFC9C3D8),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 21.sp
                )
            }
            Spacer(Modifier.height(24.dp))
            Text(
                "NATIVE ANDROID • VERSION 0.1.0",
                color = Color(0xFF8F89A5),
                fontSize = 10.sp
            )
        }
    }
}
