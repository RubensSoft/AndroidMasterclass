package com.example.androidmasterclass.retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AlbumService {
    @GET(value = "/albums")
    suspend fun getAlbums() : Response<Albums>

    @GET(value = "/albums")
    suspend fun getSortedAlbums(@Query("userID") userId: Int) : Response<Albums>

    @GET("/albums/{id}")
    suspend fun getAlbum(@Path("id") id: Int) : Response<AlbumItem>
}