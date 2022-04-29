package com.example.androidmasterclass.presentation.di.core

import com.example.androidmasterclass.data.repository.artist.ArtistRepositoryImpl
import com.example.androidmasterclass.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.androidmasterclass.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.androidmasterclass.data.repository.artist.datasource.ArtistRemoteDatasource
import com.example.androidmasterclass.data.repository.movie.MovieRepositoryImpl
import com.example.androidmasterclass.data.repository.movie.datasource.MovieCacheDataSource
import com.example.androidmasterclass.data.repository.movie.datasource.MovieLocalDataSource
import com.example.androidmasterclass.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.androidmasterclass.data.repository.tvshow.TvShowRepositoryImpl
import com.example.androidmasterclass.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.androidmasterclass.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.androidmasterclass.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.example.androidmasterclass.domain.repository.ArtistRepository
import com.example.androidmasterclass.domain.repository.MovieRepository
import com.example.androidmasterclass.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDatasource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDatasource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }
}