package com.app.rickandmorty.ui.episode.search

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.rickandmorty.domain.model.Episode
import com.app.rickandmorty.ui.component.RatingBar
import com.app.rickandmorty.ui.theme.RickAndMortyTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.roundToInt

@Composable
fun EpisodeCard(episode: Episode) {
    val dateFormat = SimpleDateFormat("MMMM d, yyyy", Locale.US)
    val colorScheme = MaterialTheme.colorScheme
    val rating = (Math.random() * 5).roundToInt()

    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(2.dp),
        border = BorderStroke(2.dp, color = colorScheme.tertiary)

    ) {

        Row(modifier = Modifier.padding(20.dp)) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = episode.name,
                    style = TextStyle(
                        color = colorScheme.tertiary,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Row {
                    Text(
                        text = dateFormat.format(episode.date),
                        style = TextStyle(
                            color = colorScheme.onPrimary,
                            fontSize = 12.sp
                        )
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = episode.code,
                        style = TextStyle(
                            color = colorScheme.onPrimary,
                            fontSize = 12.sp,
                            fontStyle = FontStyle.Italic
                        )
                    )
                }

                RatingBar(
                    modifier = Modifier.padding(top = 5.dp),
                    rating = rating.toFloat()
                )

                Spacer(modifier = Modifier.height(20.dp))

                OutlinedButton(onClick = { /*TODO*/ }) {
                    Text(text = "Download")
                }
            }
            
            TextButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = if (rating >= 3) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                    contentDescription = "Heart Icon",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EpisodeCardDefaultPreview() {
    RickAndMortyTheme {
        EpisodeCard(
            episode = Episode(
                id = 1,
                name = "Pilot",
                date = Date(2013, 11, 2),
                code = "S01E01"
            )
        )
    }
}