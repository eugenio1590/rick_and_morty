package com.app.rickandmorty.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data Transfer Object (DTO) representing an episode.
 *
 * This class is used for transferring episode data between different layers of the application,
 * such as the remote service and the data layer.
 *
 * @property id The unique identifier of the episode.
 * @property name The name or title of the episode.
 * @property date The date when the episode was released as a string (format MMMM d, yyyy).
 * @property code A code or identifier associated with the episode.
 */
@Serializable
data class EpisodeDTO(
    val id: Int,
    val name: String,
    @SerialName("air_date")
    val date: String,
    @SerialName("episode")
    val code: String
)
