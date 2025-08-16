package com.idealmind.testscreen.data.model


import androidx.annotation.DrawableRes
import java.util.UUID

data class ActivityItem(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val subtitle: String = "",
    @DrawableRes val iconRes: Int,
    val type: ActivityType,
    val hasAction: Boolean = false,
    val actionText: String = "",
    val timestamp: Long = System.currentTimeMillis()
) {
    enum class ActivityType { USER, ACHIEVEMENT, TEAM }
}
