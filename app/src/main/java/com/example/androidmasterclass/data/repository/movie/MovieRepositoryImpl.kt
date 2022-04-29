package com.example.androidmasterclass.data.repository.movie

import android.util.Log
import com.example.androidmasterclass.data.model.movie.Movie
import com.example.androidmasterclass.data.repository.movie.datasource.MovieCacheDataSource
import com.example.androidmasterclass.data.repository.movie.datasource.MovieLocalDataSource
import com.example.androidmasterclass.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.androidmasterclass.domain.repository.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
): MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    private suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>
        movieRemoteDataSource.getMovies().body()?.let {
            movieList = it.movies
        }
        return movieList
    }

    private suspend fun getMoviesFromDB(): List<Movie> {
        var movieList = movieLocalDataSource.getMoviesFromDB()
        when(movieList.size) {
            0 -> movieList = getMoviesFromAPI()
            else -> return movieList
        }
        return movieList
    }

    private suspend fun getMoviesFromCache(): List<Movie> {
        var movieList = movieCacheDataSource.getMoviesFromCache()
        when(movieList.size) {
            0 -> {
                movieList = getMoviesFromDB()
                movieCacheDataSource.saveMoviesToCache(movieList)
            }
            else -> return movieList
        }
        return movieList
    }

}