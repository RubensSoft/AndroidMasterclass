package com.example.androidmasterclass.data.repository.tvshow.datasourceImpl

import com.example.androidmasterclass.data.model.tvshow.TvShow
import com.example.androidmasterclass.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
       tvShowList.clear()
       tvShowList = ArrayList(tvShows)
    }
}