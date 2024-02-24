package com.app.rickandmorty.ui.component

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun Spinner(modifier: Modifier = Modifier) {
    val strokeWidth = 5.dp
    val color = MaterialTheme.colorScheme.primary
    CircularProgressIndicator(
        modifier = modifier.drawBehind {
            drawCircle(
                color,
                radius = size.width / 2 - strokeWidth.toPx() / 2,
                style = Stroke(strokeWidth.toPx())
            )
        },
        color = Color.LightGray,
        strokeWidth = strokeWidth
    )
}