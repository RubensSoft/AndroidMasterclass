package com.example.androidmasterclass.domain.repository

import com.example.androidmasterclass.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}