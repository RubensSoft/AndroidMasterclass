package com.example.androidmasterclass.domain.usecase

import com.example.androidmasterclass.data.model.artist.Artist
import com.example.androidmasterclass.domain.repository.ArtistRepository

class UpdateArtistsUseCase(
    private val artistRepository: ArtistRepository
) {
    suspend fun run(): List<Artist>? = artistRepository.updateArtists()
}