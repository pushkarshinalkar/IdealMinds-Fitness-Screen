package com.idealmind.testscreen.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.idealmind.testscreen.R
import com.idealmind.testscreen.ui.theme.FitnessColors.ToolbarBg

@Composable
fun TopToolbar(
    modifier: Modifier = Modifier
) {
    val statusBarPadding = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp + statusBarPadding)
            .background(ToolbarBg)
            .padding(
                top = statusBarPadding,
                start = 16.dp,
                end = 16.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {}) {
            Image(
                painter = painterResource(id = R.drawable.ic_smartwatch),
                contentDescription = "Device",
                modifier = Modifier.size(30.dp)
            )
        }

        IconButton(onClick = {}) {
            Image(
                painter = painterResource(id = R.drawable.ic_notification),
                contentDescription = "Notifications",
                colorFilter = ColorFilter.tint(Color(0xFFFFD700)),
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
