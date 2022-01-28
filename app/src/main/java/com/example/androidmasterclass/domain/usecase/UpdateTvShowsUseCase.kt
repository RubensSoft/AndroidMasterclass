package com.example.androidmasterclass.domain.usecase

import com.example.androidmasterclass.data.model.tvshow.TvShow
import com.example.androidmasterclass.domain.repository.TvShowRepository

class UpdateTvShowsUseCase(
    private val tvShowRepository: TvShowRepository
) {
    suspend fun run(): List<TvShow>? = tvShowRepository.updateTvShows()
}