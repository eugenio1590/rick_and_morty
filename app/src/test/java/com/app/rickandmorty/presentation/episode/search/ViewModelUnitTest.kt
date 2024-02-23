package com.app.rickandmorty.presentation.episode.search

import com.app.rickandmorty.config.MainDispatcherRule
import com.app.rickandmorty.domain.interactor.episode.SearchEpisodes
import com.app.rickandmorty.domain.model.Episode
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.Date

@OptIn(ExperimentalCoroutinesApi::class)
class ViewModelUnitTest {

    private val searchEpisodes: SearchEpisodes = mockk()
    private lateinit var viewModel: ViewModel

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Before
    fun setUp() {
        viewModel = ViewModel(searchEpisodes)
    }

    @Test
    fun `should indicate the first initial state`() {
        assertEquals(UiState(), viewModel.uiState.value)
    }

    @Test
    fun `should handle the intent to load episodes at first`() = runTest {
        // Given
        val intent = ViewIntent.LoadEpisodes

        val episode = Episode(id = 1, name = "Episode 1", date = Date(), code = "E001")
        val episodes = listOf(episode)
        coEvery { searchEpisodes(any(), any()) }.returns(episodes)

        // When
        viewModel.handle(intent)

        // Then
        val state = viewModel.uiState.value.loadState
        assertTrue(state is LoadState.Success)
        assertEquals(episodes, (state as LoadState.Success).episodes)
    }

    @Test
    fun `should handle the intent to load more episodes`() = runTest {
        // Given
        val intent = ViewIntent.LoadMoreEpisodes

        val episode = Episode(id = 2, name = "Episode 2", date = Date(), code = "E002")
        val episodes = listOf(episode)
        coEvery { searchEpisodes(any(), any()) }.returns(episodes)

        viewModel.update(UiState(page = 1, loadState = LoadState.Success(listOf(episode.copy(id = 1)))))

        // When
        viewModel.handle(intent)

        // Then
        val state = viewModel.uiState.value
        val loadState = state.loadState
        assertEquals(2, state.page)
        assertTrue(loadState is LoadState.Success)
    }

    @Test
    fun `should handle the intent to refresh episodes to load the first page again`() = runTest {
        // Given
        val intent = ViewIntent.RefreshEpisodes

        val episode = Episode(id = 1, name = "Episode 1", date = Date(), code = "E001")
        val episodes = listOf(episode)
        coEvery { searchEpisodes(any(), any()) }.returns(episodes)

        viewModel.update(UiState(page = 2, loadState = LoadState.Success(listOf(episode.copy(id = 2)))))

        // When
        viewModel.handle(intent)

        // Then
        val state = viewModel.uiState.value
        val loadState = state.loadState
        assertEquals(1, state.page)
        assertTrue(loadState is LoadState.Success)
    }
}