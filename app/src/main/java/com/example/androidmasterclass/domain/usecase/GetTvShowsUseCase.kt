package com.example.androidmasterclass.domain.usecase

import com.example.androidmasterclass.data.model.tvshow.TvShow
import com.example.androidmasterclass.domain.repository.TvShowRepository

class GetTvShowsUseCase(
    private val tvshowRepository: TvShowRepository
){
    suspend fun run(): List<TvShow>? = tvshowRepository.getTvShows()
}