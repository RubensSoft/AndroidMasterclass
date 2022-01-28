package com.example.androidmasterclass.domain.repository

import com.example.androidmasterclass.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists():List<Artist>?
    suspend fun updateArtists():List<Artist>?
}