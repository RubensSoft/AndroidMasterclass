package com.example.androidmasterclass.presentation.di.core

import com.example.androidmasterclass.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.androidmasterclass.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.example.androidmasterclass.data.repository.movie.datasource.MovieCacheDataSource
import com.example.androidmasterclass.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.example.androidmasterclass.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.androidmasterclass.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistsCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }

}