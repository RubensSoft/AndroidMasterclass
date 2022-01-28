package com.example.androidmasterclass.presentation.di.core

import com.example.androidmasterclass.data.api.TMDBService
import com.example.androidmasterclass.data.repository.artist.datasource.ArtistRemoteDatasource
import com.example.androidmasterclass.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.example.androidmasterclass.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.androidmasterclass.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.example.androidmasterclass.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.example.androidmasterclass.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(
    private val apiKey: String
) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDatasource {
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDatasource {
        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }
}