package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = ElectricCyan,
    onPrimary = Color.White,
    primaryContainer = SoftCyanContainer,
    onPrimaryContainer = DeepCyanContainer,
    secondary = EmeraldAccent,
    onSecondary = Color.White,
    secondaryContainer = SoftEmeraldContainer,
    onSecondaryContainer = DeepEmeraldContainer,
    background = LightBackground,
    onBackground = LightOnSurface,
    surface = LightSurface,
    onSurface = LightOnSurface,
    surfaceVariant = LightSurfaceVariant,
    onSurfaceVariant = LightOnSurfaceVariant,
    outline = LightOutline
)

private val DarkColorScheme = darkColorScheme(
    primary = BrightCyan,
    onPrimary = MidnightNavy,
    primaryContainer = DeepCyanContainer,
    onPrimaryContainer = SoftCyanContainer,
    secondary = BrightEmerald,
    onSecondary = MidnightNavy,
    secondaryContainer = DeepEmeraldContainer,
    onSecondaryContainer = SoftEmeraldContainer,
    background = MidnightNavy,
    onBackground = DarkOnSurface,
    surface = DeepSlate,
    onSurface = DarkOnSurface,
    surfaceVariant = CardSlate,
    onSurfaceVariant = DarkOnSurfaceVariant,
    outline = DarkOutline
)

@Composable
fun CryptoScriptTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}
