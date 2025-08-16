package com.idealmind.testscreen.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF00E5A0),
    onPrimary = Color(0xFF000000),
    secondary = Color(0xFF4A90E2),
    onSecondary = Color.White,
    background = Color(0xFF1A1B23),
    onBackground = Color.White,
    surface = Color(0xFF2A2B35),
    onSurface = Color.White,
    error = Color(0xFFFF6B6B)
)

@Composable
fun FitnessTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}