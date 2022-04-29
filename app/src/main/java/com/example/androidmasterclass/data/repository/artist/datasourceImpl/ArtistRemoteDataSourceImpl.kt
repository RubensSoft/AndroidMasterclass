package com.example.androidmasterclass.data.repository.artist.datasourceImpl

import com.example.androidmasterclass.data.repository.artist.datasource.ArtistRemoteDatasource
import com.example.androidmasterclass.data.api.TMDBService

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
): ArtistRemoteDatasource {
    override suspend fun getArtists() = tmdbService.getPopularArtists(apiKey)
}

