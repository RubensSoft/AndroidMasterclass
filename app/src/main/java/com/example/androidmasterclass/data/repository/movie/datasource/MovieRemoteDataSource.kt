package com.example.androidmasterclass.data.repository.movie.datasource

import com.example.androidmasterclass.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}