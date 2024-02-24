package com.app.rickandmorty.di

import com.app.rickandmorty.domain.interactor.episode.SearchEpisodes
import com.app.rickandmorty.domain.interactor.episode.SearchEpisodesUseCase
import com.app.rickandmorty.domain.repository.EpisodeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {
    @Provides
    fun provideSearchEpisodes(episodeRepository: EpisodeRepository): SearchEpisodes {
        return SearchEpisodesUseCase(episodeRepository)
    }
}
