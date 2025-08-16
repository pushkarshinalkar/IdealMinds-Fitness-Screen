package com.idealmind.testscreen.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.idealmind.testscreen.ui.components.*

@Composable
fun FitnessDashboard() {
    val todaySteps = 12658
    val weeklySteps = listOf(0.9f, 0.5f, 0.7f, 0.3f, 0.7f, 0.5f)
    val dashboardGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF283148),
            Color(0xFF0B101D)
        )
    )

    Scaffold(
        topBar = { TopToolbar() },
        bottomBar = { BottomNavigationBar(selectedTab = 0, onTabSelected = {}) },
        containerColor = Color(0xFF1A1B23)
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(dashboardGradient),
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            item { HeaderSection(onSetGoalClick = {}) }
            item { StepsCircularProgress(currentSteps = todaySteps, goalSteps = 18500) }
            item { Spacer(Modifier.height(24.dp)) }
            item { MetricsRow(activeMinutes = 120, distance = 8f, calories = 1800) }
            item { Spacer(Modifier.height(32.dp)) }
            item { WeeklyChart(weeklyData = weeklySteps, selectedDay = 5) }
            item { Spacer(Modifier.height(32.dp)) }
            item { ActivityFeed(sampleActivities()) }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DashboardPreview() = FitnessDashboard()
