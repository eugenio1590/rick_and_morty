package com.app.rickandmorty.ui.episode.search

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.rickandmorty.domain.model.Episode
import com.app.rickandmorty.ui.theme.RickAndMortyTheme
import java.util.Date

@Composable
fun EpisodeList(episodes: List<Episode>, loadMore: () -> Unit) {
    val listState = rememberLazyListState()

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        state = listState
    ) {
        items(episodes.size) {index ->
            val item = episodes[index]
            EpisodeCard(episode = item)
            if (index == episodes.size - 1) {
                loadMore()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EpisodeListDefaultPreview() {
    RickAndMortyTheme {
        EpisodeList(
            episodes = listOf(
                Episode(
                    id = 1,
                    name = "Pilot",
                    date = Date(2013, 11, 2),
                    code = "S01E01"
                ),
                Episode(
                    id = 28,
                    name = "The Ricklantis Mixup",
                    date = Date(2017, 8, 10),
                    code = "S03E07"
                )
            ),
            loadMore = {}
        )
    }
}
