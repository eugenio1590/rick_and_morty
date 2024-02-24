package com.app.rickandmorty.ui.episode.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
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
import com.app.rickandmorty.ui.theme.RickAndMortyTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun EpisodeCard(episode: Episode) {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.US)

    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))

    ) {

        Row(modifier = Modifier.padding(20.dp)) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = episode.name,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Row {
                    Text(
                        text = "${episode.code} - ",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 12.sp
                        )
                    )
                    Text(
                        text = dateFormat.format(episode.date),
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 12.sp,
                            fontStyle = FontStyle.Italic
                        )
                    )
                }
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