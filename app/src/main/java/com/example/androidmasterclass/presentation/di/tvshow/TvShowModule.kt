package com.example.androidmasterclass.presentation.di.tvshow

import com.example.androidmasterclass.domain.usecase.GetTvShowsUseCase
import com.example.androidmasterclass.domain.usecase.UpdateTvShowsUseCase
import com.example.androidmasterclass.presentation.tvshows.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }

}