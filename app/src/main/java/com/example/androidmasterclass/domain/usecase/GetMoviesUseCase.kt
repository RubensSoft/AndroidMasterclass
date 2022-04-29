package com.example.androidmasterclass.domain.usecase

import com.example.androidmasterclass.data.model.movie.Movie
import com.example.androidmasterclass.domain.repository.MovieRepository

class GetMoviesUseCase(
    private val movieRepository: MovieRepository
){
    suspend fun run(): List<Movie>? = movieRepository.getMovies()
}