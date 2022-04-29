package com.example.androidmasterclass.data.repository.tvshow.datasource

import com.example.androidmasterclass.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {
   suspend fun getTvShows(): Response<TvShowList>
}