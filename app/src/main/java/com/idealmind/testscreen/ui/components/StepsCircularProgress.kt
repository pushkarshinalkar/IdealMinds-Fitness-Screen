package com.idealmind.testscreen.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.idealmind.testscreen.ui.theme.FitnessColors.CircularProgressBg
import com.idealmind.testscreen.ui.theme.SFProRounded

@Composable
fun StepsCircularProgress(
    currentSteps: Int,
    goalSteps: Int,
    modifier: Modifier = Modifier
) {
    val progress = (currentSteps.toFloat() / goalSteps).coerceAtMost(1f)
    val animated by animateFloatAsState(progress, tween(1200))

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(320.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(Modifier.size(280.dp)) {

            val trackStroke = 6.dp.toPx()
            val progressStroke = 22.dp.toPx()
            val radius = (size.minDimension - progressStroke) / 2f

            drawCircle(CircularProgressBg, radius, center)

            drawCircle(
                color = Color(0xFF4A587A),
                radius = radius,
                style = Stroke(trackStroke, cap = StrokeCap.Round)
            )

            drawArc(
                color = Color(0xFF00E5A0),
                startAngle = -90f,
                sweepAngle = animated * 360f,
                useCenter = false,
                style = Stroke(progressStroke, cap = StrokeCap.Round),
                size = Size(radius * 2, radius * 2),
                topLeft = Offset(center.x - radius, center.y - radius)
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.offset(y = (16).dp)
        ) {
            Text(
                text = "%,d".format(currentSteps),
                fontSize = 50.sp,
                color = Color.White,
                fontFamily = SFProRounded,
                fontWeight = FontWeight.ExtraBold
            )

            Spacer(Modifier.height(12.dp))

            Text(
                text = "Steps",
                fontSize = 26.sp,
                color = Color(0xFF00E5A0),
                fontFamily = SFProRounded,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


