package com.example.androidmasterclass.data.repository.tvshow

import com.example.androidmasterclass.data.model.tvshow.TvShow
import com.example.androidmasterclass.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.androidmasterclass.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.androidmasterclass.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.example.androidmasterclass.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDatasource: TvShowRemoteDatasource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
       return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    private suspend fun getTvShowsFromAPI(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        tvShowRemoteDatasource.getTvShows().body()?.let {
            tvShowList = it.tvShows
        }
        return tvShowList
    }

    private suspend fun getTvShowsFromDB():List<TvShow>{
        var tvShowsList = tvShowLocalDataSource.getTvShowsFromDB()
        when(tvShowsList.size) {
            0 -> tvShowsList = getTvShowsFromAPI()
            else -> return tvShowsList
        }
        return tvShowsList
    }

    private suspend fun getTvShowsFromCache():List<TvShow>{
        var tvShowsList = tvShowCacheDataSource.getTvShowsFromCache()
        when(tvShowsList.size) {
            0 -> {
                tvShowsList = getTvShowsFromDB()
                tvShowCacheDataSource.saveTvShowsToCache(tvShowsList)
            }
            else -> tvShowsList
        }
        return tvShowsList
    }







}