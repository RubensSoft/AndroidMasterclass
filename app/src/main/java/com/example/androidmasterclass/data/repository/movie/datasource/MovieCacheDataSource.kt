package com.example.androidmasterclass.data.repository.movie.datasource

import com.example.androidmasterclass.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movie: List<Movie>)
}