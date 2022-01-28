package com.example.androidmasterclass.domain.repository

import com.example.androidmasterclass.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}