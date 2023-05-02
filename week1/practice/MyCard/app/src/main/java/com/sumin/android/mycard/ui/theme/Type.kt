package com.sumin.android.mycard.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sumin.android.mycard.R

val suit = FontFamily(
    Font(R.font.suit_bold, FontWeight.Bold),
    Font(R.font.suit_regular, FontWeight.Normal)
)

// Set of Material typography styles to start with
val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = suit,
        fontWeight = FontWeight.Normal,
        fontSize = 50.sp,
        letterSpacing = (-2).sp
    ),
    bodyLarge = TextStyle(
        fontFamily = suit,
        fontWeight = FontWeight.Normal,
    ),
    bodySmall = TextStyle(
        fontFamily = suit,
        fontWeight = FontWeight.Bold,
    )
)