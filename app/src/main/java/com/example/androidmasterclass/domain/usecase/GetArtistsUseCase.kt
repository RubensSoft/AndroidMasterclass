package com.example.androidmasterclass.domain.usecase

import com.example.androidmasterclass.data.model.artist.Artist
import com.example.androidmasterclass.domain.repository.ArtistRepository

class GetArtistsUseCase(
    private val artistRepository: ArtistRepository
) {
    suspend fun execute(): List<Artist>? = artistRepository.getArtists()
}