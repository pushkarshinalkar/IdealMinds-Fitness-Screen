package com.idealmind.testscreen.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.idealmind.testscreen.ui.theme.SFProRounded

@Composable
fun WeeklyChart(
    weeklyData: List<Float>,
    selectedDay: Int,
    modifier: Modifier = Modifier
) {
    val days = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
    var labelPositions by remember { mutableStateOf(List(days.size) { 0f }) }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            days.forEachIndexed { index, day ->
                Box(
                    modifier = Modifier
                        .onGloballyPositioned { coordinates ->

                            val centerX =
                                coordinates.positionInParent().x + coordinates.size.width / 2f
                            val newPositions = labelPositions.toMutableList()
                            newPositions[index] = centerX
                            labelPositions = newPositions
                        }
                ) {
                    if (index == selectedDay) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .background(Color(0xFF00E5A0))
                                .padding(horizontal = 6.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = day,
                                color = Color.Black,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium,
                                fontFamily = SFProRounded
                            )
                        }
                    } else {
                        Text(
                            text = day,
                            color = Color(0xFFFFFFFF),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = SFProRounded
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))


        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(horizontal = 16.dp)
        ) {
            if (weeklyData.isNotEmpty() && labelPositions.all { it > 0f }) {
                drawWeeklyChart(weeklyData, labelPositions, selectedDay)
            }
        }
    }
}

private fun androidx.compose.ui.graphics.drawscope.DrawScope.drawWeeklyChart(
    data: List<Float>,
    labelPositions: List<Float>,
    selectedDay: Int
) {
    val height = size.height
    val maxValue = data.maxOrNull() ?: 1f


    val points = data.mapIndexed { index, value ->
        androidx.compose.ui.geometry.Offset(
            x = labelPositions.getOrElse(index) { 0f },
            y = height - (value / maxValue * height * 0.8f) - height * 0.1f
        )
    }


    val gradientPath = Path().apply {
        moveTo(points.first().x, height)
        points.forEach {
            lineTo(it.x, it.y)
        }
        lineTo(points.last().x, height)
        close()
    }

    drawPath(
        path = gradientPath,
        brush = Brush.verticalGradient(
            colors = listOf(
                Color(0x6600E5A0),
                Color.Transparent
            ),
            startY = 0f,
            endY = height
        )
    )


    val linePath = Path().apply {
        moveTo(points.first().x, points.first().y)
        points.drop(1).forEach {
            lineTo(it.x, it.y)
        }
    }

    drawPath(
        path = linePath,
        color = Color(0xFF00E5A0),
        style = Stroke(width = 3.dp.toPx(), cap = StrokeCap.Round)
    )


    points.forEachIndexed { index, point ->

        drawLine(
            color = if (index == selectedDay) Color(0xFF006AF9) else Color(0x4400002C),
            strokeWidth = 2.dp.toPx(),
            start = androidx.compose.ui.geometry.Offset(point.x, 0f),
            end = androidx.compose.ui.geometry.Offset(point.x, height)
        )


        if (index == selectedDay) {

            drawCircle(
                color = Color(0xFF00E5A0),
                radius = 6.dp.toPx(),
                center = point
            )


            drawCircle(
                color = Color(0xFF00E5A0),
                radius = 8.dp.toPx(),
                center = point,
                style = Stroke(width = 1.dp.toPx())
            )
        } else {

            drawCircle(
                color = Color(0xFFFFFFFF),
                radius = 4.dp.toPx(),
                center = point
            )
        }
    }
}
