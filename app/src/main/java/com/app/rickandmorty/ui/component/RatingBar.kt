package com.app.rickandmorty.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RatingBar(
    rating: Float,
    maxRating: Int = 5,
    modifier: Modifier = Modifier,
    activeColor: Color = Color(251, 188, 0),
    inactiveColor: Color = Color.Gray
) {
    Row(modifier = modifier) {
        repeat(maxRating) { index ->
            val iconColor = if (index < rating) activeColor else inactiveColor
            Icon(imageVector = Icons.Default.Star, contentDescription = null, tint = iconColor)
        }
    }
}

@Preview
@Composable
fun RatingBarPreview() {
    RatingBar(rating = 3.5f, maxRating = 5, modifier = Modifier.padding(16.dp))
}
