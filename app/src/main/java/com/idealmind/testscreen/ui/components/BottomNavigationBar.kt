package com.idealmind.testscreen.ui.components



import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.idealmind.testscreen.R

@Composable
fun BottomNavigationBar(
    selectedTab: Int,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier,
        containerColor = Color(0xFF1A1B23),
        contentColor = Color.White
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = "Home",
                    tint = Color.Unspecified
                )
            },
            label = { Text("Home", fontSize = 12.sp) },
            selected = selectedTab == 0,
            onClick = { onTabSelected(0) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Unspecified,
                selectedTextColor = Color(0xFF00E5A0),
                unselectedIconColor = Color.Unspecified,
                unselectedTextColor = Color(0xFF6B6B6B),
                indicatorColor = Color.Transparent
            )
        )

        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_feed),
                    contentDescription = "Feed",
                    tint = Color.Unspecified
                )
            },
            label = { Text("Stats", fontSize = 12.sp) },
            selected = selectedTab == 1,
            onClick = { onTabSelected(1) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Unspecified,
                selectedTextColor = Color(0xFF00E5A0),
                unselectedIconColor = Color.Unspecified,
                unselectedTextColor = Color(0xFF6B6B6B),
                indicatorColor = Color.Transparent
            )
        )

        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "Profile",
                    tint = Color.Unspecified
                )
            },
            label = { Text("Profile", fontSize = 12.sp) },
            selected = selectedTab == 2,
            onClick = { onTabSelected(2) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Unspecified,
                selectedTextColor = Color(0xFF00E5A0),
                unselectedIconColor = Color.Unspecified,
                unselectedTextColor = Color(0xFF6B6B6B),
                indicatorColor = Color.Transparent
            )
        )
    }
}
