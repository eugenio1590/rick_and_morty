package com.app.rickandmorty.domain.interactor.episode

import com.app.rickandmorty.domain.model.Episode
import com.app.rickandmorty.domain.repository.EpisodeRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import java.util.Date
import org.junit.Assert.assertEquals
import org.junit.Test

class SearchEpisodesUnitTest {

    private val episodeRepository: EpisodeRepository = mockk()
    private val searchEpisodes: SearchEpisodes = SearchEpisodesUseCase(episodeRepository)

    @Test
    fun `when the use case is invoked should return expected list of episodes`(): Unit = runBlocking {
        // Given
        val episode = Episode(id = 1, name = "EP01", date = Date(), code = "EPX01")
        coEvery { episodeRepository.find(any(), any()) }.returns(listOf(episode))

        // When
        val episodes = searchEpisodes(page = 1, limit = 10)

        // Then
        assertEquals(1, episodes.size)
        coVerify { episodeRepository.find(any(), any()) }
    }

    @Test(expected = Error::class)
    fun `when the use case is invoked should throw an exception on failure`(): Unit = runBlocking {
        // Given
        coEvery { episodeRepository.find(any(), any()) }.throws(Error("Unexpected error"))

        // When
        searchEpisodes(page = 1, limit = 10)
    }
}
