package com.example.androidmasterclass.presentation.di

import com.example.androidmasterclass.presentation.di.artist.ArtistSubComponent
import com.example.androidmasterclass.presentation.di.movie.MovieSubComponent
import com.example.androidmasterclass.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}