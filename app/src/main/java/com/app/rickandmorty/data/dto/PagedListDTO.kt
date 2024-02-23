package com.app.rickandmorty.data.dto

import kotlinx.serialization.Serializable

/**
 * Data Transfer Object (DTO) representing a paginated list of episodes.
 *
 * This class is used for transferring a paginated list of episode data between different layers
 * of the application, such as the remote service and the data layer.
 *
 * @property results The list of [EpisodeDTO] objects representing the paginated episode data.
 */
@Serializable
data class PagedListDTO(val results: List<EpisodeDTO>): Collection<EpisodeDTO> by results
