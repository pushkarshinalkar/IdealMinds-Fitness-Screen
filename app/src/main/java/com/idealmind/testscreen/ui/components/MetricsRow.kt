package com.idealmind.testscreen.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.idealmind.testscreen.ui.theme.FitnessColors.Primary
import com.idealmind.testscreen.ui.theme.SFProRounded

@Composable
fun MetricsRow(
    activeMinutes: Int,
    distance: Float,
    calories: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        MetricCard(
            title = "Active",
            value = activeMinutes.toString(),
            unit = "min",
            valueColor = Color.White,
            progressColor = Color(0xFF4A90E2),
            progress = 0.8f
        )

        MetricCard(
            title = "Distance",
            value = String.format("%.1f", distance),
            unit = "km",
            valueColor = Color.White,
            progressColor = Color(0xFFE94B7A),
            progress = 0.4f
        )

        MetricCard(
            title = "Calories",
            value = calories.toString(),
            unit = "kcal",
            valueColor = Color.White,
            progressColor = Color(0xFFFFB84D),
            progress = 0.6f
        )
    }
}

@Composable
private fun MetricCard(
    title: String,
    value: String,
    unit: String,
    valueColor: Color,
    progressColor: Color,
    progress: Float,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier.width(IntrinsicSize.Max)
    ) {
        Text(
            text = title,
            color = Color(0xFFFFFFFF),
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = SFProRounded
        )

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = value,
                color = valueColor,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = SFProRounded
            )
            Text(
                text = unit,
                color = Primary,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = SFProRounded,
                modifier = Modifier.padding(start = 4.dp, bottom = 2.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .width(70.dp)
                .height(7.dp)
                .clip(RoundedCornerShape(3.dp))
                .background(Color(0xFF4A587A))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(progress)
                    .clip(RoundedCornerShape(3.dp))
                    .background(progressColor)
            )
        }
    }
}
