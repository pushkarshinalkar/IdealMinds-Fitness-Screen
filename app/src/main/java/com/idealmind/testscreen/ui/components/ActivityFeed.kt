package com.idealmind.testscreen.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.idealmind.testscreen.data.model.ActivityItem
import com.idealmind.testscreen.ui.theme.SFProRounded

@Composable
fun ActivityFeed(
    activities: List<ActivityItem>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {

        Text(
            text = "Recent Activity",
            color = Color(0xFF00E5A0),
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = SFProRounded,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp)
        )


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF1A1B23))
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp, bottom = 24.dp)
        ) {
            activities.take(3).forEachIndexed { index, activity ->
                ActivityItem(
                    activity = activity,
                    modifier = Modifier.padding(
                        bottom = if (index < activities.take(3).size - 1) 30.dp else 0.dp
                    )
                )
            }
        }
    }
}

@Composable
private fun ActivityItem(
    activity: ActivityItem,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        when (activity.type) {
            ActivityItem.ActivityType.USER -> {
                Icon(
                    painter = painterResource(id = activity.iconRes),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(40.dp)
                )
            }

            ActivityItem.ActivityType.ACHIEVEMENT -> {
                Icon(
                    painter = painterResource(id = activity.iconRes),
                    contentDescription = null,
                    tint = Color(0xFFFFD700),
                    modifier = Modifier.size(40.dp)
                )
            }

            ActivityItem.ActivityType.TEAM -> {
                Icon(
                    painter = painterResource(id = activity.iconRes),
                    contentDescription = null,
                    tint = Color(0xFF4A90E2),
                    modifier = Modifier.size(40.dp)
                )
            }
        }

        Spacer(modifier = Modifier.width(12.dp))


        Column(
            modifier = Modifier
                .weight(1f)
                .wrapContentHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = activity.title,
                color = Color(0xFFC4D0EF),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = SFProRounded,
                lineHeight = 18.sp
            )
        }

        if (activity.hasAction) {
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00E5A0),
                    contentColor = Color(0xFF282828)
                ),
                shape = RoundedCornerShape(6.dp),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp),
                modifier = Modifier.wrapContentHeight()
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.wrapContentSize()
                ) {
                    Text(
                        text = activity.actionText,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = SFProRounded,
                        lineHeight = 13.sp
                    )
                }
            }
        }
    }
}

