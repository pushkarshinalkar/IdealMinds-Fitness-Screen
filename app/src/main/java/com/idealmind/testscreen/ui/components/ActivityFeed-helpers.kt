package com.idealmind.testscreen.ui.components


import com.idealmind.testscreen.R
import com.idealmind.testscreen.data.model.ActivityItem

fun sampleActivities() = listOf(
    ActivityItem(
        title = "Alexander Skits cheered you",
        iconRes = R.drawable.ic_activity_1,
        type = ActivityItem.ActivityType.USER,
        hasAction = true,
        actionText = "Cheer Back"
    ),
    ActivityItem(
        title = "5-Day Streak Badge Earned",
        iconRes = R.drawable.ic_activity_2,
        type = ActivityItem.ActivityType.ACHIEVEMENT
    ),
    ActivityItem(
        title = "Team Dubai just took the lead",
        iconRes = R.drawable.ic_activity_3,
        type = ActivityItem.ActivityType.TEAM
    )
)
