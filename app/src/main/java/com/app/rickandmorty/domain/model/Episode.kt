package com.app.rickandmorty.domain.model

import java.util.Date

/**
 * Represents an episode of the series.
 *
 * @property id Unique identifier for the episode.
 * @property name The name or title of the episode.
 * @property date The release date of the episode.
 * @property code A code associated with the episode.
 */
data class Episode(
    val id: Int,
    val name: String,
    val date: Date,
    val code: String
)
