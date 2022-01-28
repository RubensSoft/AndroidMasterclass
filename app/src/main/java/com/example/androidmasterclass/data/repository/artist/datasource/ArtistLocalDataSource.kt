package com.example.androidmasterclass.data.repository.artist.datasource

import com.example.androidmasterclass.data.model.artist.Artist

interface ArtistLocalDataSource {
  suspend fun getArtistsFromDB():List<Artist>
  suspend fun saveArtistsToDB(artists:List<Artist>)
  suspend fun clearAll()
}