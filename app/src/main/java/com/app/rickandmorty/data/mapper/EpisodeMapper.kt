package com.app.rickandmorty.data.mapper

import com.app.rickandmorty.data.dto.EpisodeDTO
import com.app.rickandmorty.domain.model.Episode
import java.lang.UnsupportedOperationException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Mapper class for converting between EpisodeDTO and Episode entities.
 *
 * This class provides methods for mapping data transfer objects (DTOs) to domain entities and vice-versa.
 */
class EpisodeMapper {

    private val dateFormat = SimpleDateFormat("MMMM d, yyyy", Locale.US)

    fun toEntity(dto: EpisodeDTO): Episode {
        return Episode(
            id = dto.id,
            name = dto.name,
            date = dateFormat.parse(dto.date) ?: Date(),
            code = dto.code
        )
    }

    fun toDTO(entity: Episode): EpisodeDTO {
        throw UnsupportedOperationException("Unimplemented method")
    }
}