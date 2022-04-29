package com.example.androidmasterclass.presentation.di.movie

import com.example.androidmasterclass.domain.usecase.GetMoviesUseCase
import com.example.androidmasterclass.domain.usecase.UpdateMoviesUseCase
import com.example.androidmasterclass.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUsecase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUsecase
        )
    }

}