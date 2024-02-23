package com.app.rickandmorty.data.mapper

import com.app.rickandmorty.data.dto.EpisodeDTO
import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.Locale

class EpisodeMapperUnitTest {

    private val episodeMapper = EpisodeMapper()
    private val dateFormat = SimpleDateFormat("MMMM d, yyyy", Locale.US)

    @Test
    fun `toEntity should map EpisodeDTO to Episode`() {
        // Given
        val episodeDTO = EpisodeDTO(id = 1, name = "Episode 1", date = "December 1, 2020", code = "E001")

        // When
        val entity = episodeMapper.toEntity(episodeDTO)

        // Then
        assertEquals(episodeDTO.id, entity.id)
        assertEquals(episodeDTO.name, entity.name)
        assertEquals(episodeDTO.code, entity.code)
        assertEquals(episodeDTO.date, dateFormat.format(entity.date))
    }
}
