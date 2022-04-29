package com.example.androidmasterclass.presentation.di.core

import com.example.androidmasterclass.data.db.ArtistDao
import com.example.androidmasterclass.data.db.MovieDao
import com.example.androidmasterclass.data.db.TvShowDao
import com.example.androidmasterclass.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.androidmasterclass.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.example.androidmasterclass.data.repository.movie.datasource.MovieLocalDataSource
import com.example.androidmasterclass.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.example.androidmasterclass.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.androidmasterclass.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

}