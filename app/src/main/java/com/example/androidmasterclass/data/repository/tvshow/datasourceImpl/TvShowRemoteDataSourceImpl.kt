package com.example.androidmasterclass.data.repository.tvshow.datasourceImpl

import com.example.androidmasterclass.data.api.TMDBService
import com.example.androidmasterclass.data.repository.tvshow.datasource.TvShowRemoteDatasource

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
): TvShowRemoteDatasource {
    override suspend fun getTvShows() = tmdbService.getPopularTvShows(apiKey)
}

