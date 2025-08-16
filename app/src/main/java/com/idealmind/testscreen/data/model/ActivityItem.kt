package com.idealmind.testscreen.data.model


import androidx.annotation.DrawableRes
import java.util.UUID

/**
 * Lightweight UI-only model for the “Recent Activity” feed.
 * You can enrich it later with real data if you add app logic.
 */
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
