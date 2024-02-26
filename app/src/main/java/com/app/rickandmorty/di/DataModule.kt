package com.app.rickandmorty.di

import android.content.Context
import com.app.rickandmorty.data.mapper.EpisodeMapper
import com.app.rickandmorty.data.source.episode.EpisodeDataSource
import com.app.rickandmorty.data.source.episode.EpisodeService
import com.app.rickandmorty.domain.repository.EpisodeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    // Repositories
    @Singleton
    @Provides
    fun provideEpisodeRepository(
        @ApplicationContext context: Context,
        episodeMapper: EpisodeMapper,
        episodeService: EpisodeService
    ): EpisodeRepository {
        return EpisodeDataSource(context, episodeMapper, episodeService)
    }

    // Mappers

    @Provides
    fun provideEpisodeMapper(): EpisodeMapper {
        return EpisodeMapper()
    }
}