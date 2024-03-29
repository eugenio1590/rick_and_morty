package com.app.rickandmorty.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.app.rickandmorty.presentation.ErrorMessage
import com.app.rickandmorty.presentation.episode.search.LoadState
import com.app.rickandmorty.presentation.episode.search.ViewIntent
import com.app.rickandmorty.presentation.episode.search.ViewModel
import com.app.rickandmorty.ui.component.Spinner
import com.app.rickandmorty.ui.component.Splash
import com.app.rickandmorty.ui.episode.search.EpisodeList

@Composable
fun EpisodesScreen(viewModel: ViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    val loadState = uiState.loadState
    Column {
        when (loadState) {
            is LoadState.Initial -> Splash()
            is LoadState.Loading -> LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
            is LoadState.Success -> EpisodeList(episodes = loadState.episodes) {
                viewModel.handle(ViewIntent.LoadMoreEpisodes)
            }
            is LoadState.Failure -> ErrorMessageScreen(
                message = ErrorMessage.NetworkMessage.NoInternetMessage
            ) {
                viewModel.handle(ViewIntent.RefreshEpisodes)
            }
        }
    }
}
