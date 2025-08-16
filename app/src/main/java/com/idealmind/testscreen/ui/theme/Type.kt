package com.idealmind.testscreen.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.idealmind.testscreen.R


val SFProRounded = FontFamily(
    Font(R.font.sf_pro_rounded, FontWeight.Normal)
)


private val Base = Typography()


val AppTypography = Typography(

    displayLarge   = Base.displayLarge.copy(  fontFamily = SFProRounded, fontWeight = FontWeight.Bold ),
    displayMedium  = Base.displayMedium.copy( fontFamily = SFProRounded, fontWeight = FontWeight.Bold ),
    displaySmall   = Base.displaySmall.copy(  fontFamily = SFProRounded, fontWeight = FontWeight.Bold ),

    headlineLarge  = Base.headlineLarge.copy(  fontFamily = SFProRounded, fontWeight = FontWeight.Bold ),
    headlineMedium = Base.headlineMedium.copy( fontFamily = SFProRounded, fontWeight = FontWeight.SemiBold ),
    headlineSmall  = Base.headlineSmall.copy(  fontFamily = SFProRounded, fontWeight = FontWeight.SemiBold ),

    titleLarge     = Base.titleLarge.copy(     fontFamily = SFProRounded, fontWeight = FontWeight.Bold ),
    titleMedium    = Base.titleMedium.copy(    fontFamily = SFProRounded, fontWeight = FontWeight.Medium ),
    titleSmall     = Base.titleSmall.copy(     fontFamily = SFProRounded, fontWeight = FontWeight.Medium ),

    bodyLarge      = Base.bodyLarge.copy(      fontFamily = SFProRounded, fontWeight = FontWeight.Normal ),
    bodyMedium     = Base.bodyMedium.copy(     fontFamily = SFProRounded, fontWeight = FontWeight.Normal ),
    bodySmall      = Base.bodySmall.copy(      fontFamily = SFProRounded, fontWeight = FontWeight.Normal ),

    labelLarge     = Base.labelLarge.copy(     fontFamily = SFProRounded, fontWeight = FontWeight.Medium ),
    labelMedium    = Base.labelMedium.copy(    fontFamily = SFProRounded, fontWeight = FontWeight.Medium ),
    labelSmall     = Base.labelSmall.copy(     fontFamily = SFProRounded, fontWeight = FontWeight.Medium )
)
