package com.app.rickandmorty.data.source.episode

import com.app.rickandmorty.data.dto.PagedListDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit service interface for interacting with the remote episode API.
 *
 * This interface defines methods for retrieving episode data from the remote service.
 */
interface EpisodeService {

    /**
     * Retrieves a paginated list of episodes from the remote service.
     *
     * @param page The page number indicating the set of episodes to retrieve.
     * @return A [Response] containing the paginated list of [PagedListDTO] representing episode data.
     */
    @GET("episode")
    suspend fun getEpisodeList(@Query("page") page: Int): Response<PagedListDTO>
}
