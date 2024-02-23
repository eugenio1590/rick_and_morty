package com.app.rickandmorty.data.source.episode

import com.app.rickandmorty.data.dto.EpisodeDTO
import com.app.rickandmorty.data.dto.PagedListDTO
import com.app.rickandmorty.data.mapper.EpisodeMapper
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import retrofit2.Response

class EpisodeDataSourceUnitTest {

    private val mapper = EpisodeMapper()
    private val service: EpisodeService = mockk()
    private val dataSource = EpisodeDataSource(mapper, service)

    @Test
    fun `find should call the service and return the episodes`(): Unit = runBlocking {
        // Given
        val page = 1
        val limit = 10
        val episode = EpisodeDTO(id = 1, name = "Episode 1", date = "December 21, 2020", code = "E001")
        val results = listOf(episode)
        val pagedList = PagedListDTO(results = results)

        coEvery { service.getEpisodeList(page = page) }.returns(Response.success(pagedList))

        // When
        val result = dataSource.find(page, limit)

        // Then
        assertEquals(results.size, result.size)
    }
}
