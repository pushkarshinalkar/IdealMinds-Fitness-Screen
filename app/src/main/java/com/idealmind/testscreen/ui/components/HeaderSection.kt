package com.idealmind.testscreen.ui.components


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun HeaderSection(
    currentDate: Date = Date(),
    onSetGoalClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val dayFormat = SimpleDateFormat("EEEE", Locale.getDefault())
    val dateFormat = SimpleDateFormat("d MMMM, yyyy", Locale.getDefault())
    val Green = Color(0xFF00E5A0)

    CompositionLocalProvider(LocalContentColor provides Green) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = dayFormat.format(currentDate),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = dateFormat.format(currentDate),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            }

            TextButton(
                onClick = onSetGoalClick,
                colors = ButtonDefaults.textButtonColors(contentColor = Green),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = "Set Goal",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}
