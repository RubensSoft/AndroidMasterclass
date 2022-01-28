package com.example.androidmasterclass.data.repository.artist.datasource

import com.example.androidmasterclass.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDatasource {
   suspend fun getArtists(): Response<ArtistList>
}