package com.zodire.app

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.WindowCompat
import com.bumptech.glide.Glide

private val Cosmic = Color(0xFF100719)
private val CosmicMid = Color(0xFF24102F)
private val Gold = Color(0xFFE7C27C)
private val GoldDeep = Color(0xFFC18B45)
private val Ivory = Color(0xFFFFF1D8)
private val Muted = Color(0xFFD0BFAF)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = android.graphics.Color.rgb(16, 7, 25)
        window.navigationBarColor = android.graphics.Color.rgb(16, 7, 25)
        WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars = false
        WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightNavigationBars = false
        setContent {
            MaterialTheme(
                colorScheme = darkColorScheme(
                    primary = Gold,
                    onPrimary = Cosmic,
                    background = Cosmic,
                    surface = CosmicMid,
                    onBackground = Ivory,
                    onSurface = Ivory
                )
            ) { ZodireHome() }
        }
    }
}

@Composable
private fun ZodireHome() {
    val scroll = rememberScrollState()
    var name by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }
    var birthPlace by remember { mutableStateOf("") }
    var showSampleNotice by remember { mutableStateOf(false) }

    Box(Modifier.fillMaxSize().background(Cosmic)) {
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(scroll),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(12.dp))
            ImageLogo()
            Text(
                text = "The power on your side",
                color = Gold,
                fontSize = 12.sp,
                letterSpacing = 2.2.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(Modifier.height(24.dp))
            Text(
                text = "Your Kundli. Your Compatibility. Your Match.",
                color = Ivory,
                fontSize = 27.sp,
                lineHeight = 34.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(horizontal = 28.dp)
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = "See how Zodire matches work with a quick preview — enter a few details and swipe through sample matches built from Vedic compatibility.",
                color = Muted,
                fontSize = 14.sp,
                lineHeight = 22.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 30.dp)
            )
            Spacer(Modifier.height(12.dp))
            ZodiacWheel(Modifier.fillMaxWidth().padding(horizontal = 12.dp).height(320.dp))
            Button(
                onClick = { showSampleNotice = true },
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Gold, contentColor = Cosmic),
                contentPadding = PaddingValues(horizontal = 30.dp, vertical = 14.dp)
            ) {
                Text("Try a quick preview  →", fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
            }
            Spacer(Modifier.height(34.dp))
            Text("Try a quick preview", color = Gold, fontSize = 21.sp)
            Spacer(Modifier.height(7.dp))
            Text(
                "A few details, and you'll see sample matches scored the way Zodire actually works.",
                color = Muted,
                fontSize = 13.sp,
                lineHeight = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 32.dp)
            )
            Spacer(Modifier.height(18.dp))
            Column(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp)
                    .background(CosmicMid, RoundedCornerShape(20.dp)).padding(18.dp)
            ) {
                PreviewField("Your name", name, { name = it })
                Spacer(Modifier.height(12.dp))
                PreviewField("Date of birth (DD/MM/YYYY)", birthDate, { birthDate = it })
                Spacer(Modifier.height(12.dp))
                PreviewField("Birth place", birthPlace, { birthPlace = it })
                Spacer(Modifier.height(16.dp))
                OutlinedButton(
                    onClick = { showSampleNotice = true },
                    modifier = Modifier.fillMaxWidth(),
                    border = androidx.compose.foundation.BorderStroke(1.dp, Gold),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Gold)
                ) { Text("Continue") }
            }
            Spacer(Modifier.height(28.dp))
            Text(
                "Preview matches shown are sample profiles, not real users. Zodire is in beta — no live matching yet.",
                color = Color(0xFF9D8C9F),
                fontSize = 11.sp,
                lineHeight = 17.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 28.dp)
            )
            Spacer(Modifier.height(12.dp))
            Text("📸 Follow @zodire.app for updates", color = Gold, fontSize = 12.sp)
            Spacer(Modifier.height(28.dp))
        }
    }

    if (showSampleNotice) {
        AlertDialog(
            onDismissRequest = { showSampleNotice = false },
            containerColor = CosmicMid,
            titleContentColor = Gold,
            textContentColor = Ivory,
            title = { Text("Zodire preview") },
            text = { Text("The sample-match experience is being prepared. Live matching is not available yet.") },
            confirmButton = {
                TextButton(onClick = { showSampleNotice = false }) { Text("Got it", color = Gold) }
            }
        )
    }
}

@Composable
private fun ImageLogo() {
    androidx.compose.foundation.Image(
        painter = painterResource(id = R.drawable.zodire_logo),
        contentDescription = "Original Zodire logo",
        modifier = Modifier.width(190.dp).height(72.dp),
        contentScale = ContentScale.Fit
    )
}

@Composable
private fun ZodiacWheel(modifier: Modifier = Modifier) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            ImageView(context).apply {
                scaleType = ImageView.ScaleType.FIT_CENTER
                setBackgroundColor(android.graphics.Color.TRANSPARENT)
                Glide.with(context).asGif().load(R.drawable.zodire_wheel_half_speed).into(this)
            }
        },
        update = { view ->
            if (view.drawable == null) {
                Glide.with(view).asGif().load(R.drawable.zodire_wheel_half_speed).into(view)
            }
        }
    )
}

@Composable
private fun PreviewField(label: String, value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        label = { Text(label) },
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Gold,
            unfocusedBorderColor = Color(0xFF6E5877),
            focusedLabelColor = Gold,
            unfocusedLabelColor = Muted,
            focusedTextColor = Ivory,
            unfocusedTextColor = Ivory,
            cursorColor = Gold
        )
    )
}
