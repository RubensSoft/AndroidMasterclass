package com.example.androidmasterclass.retrofit

import retrofit2.Response
import retrofit2.http.*

interface AlbumService {
    @GET(value = "/albums")
    suspend fun getAlbums() : Response<Albums>

    @GET(value = "/albums")
    suspend fun getSortedAlbums(@Query("userID") userId: Int): Response<Albums>

    @GET("/albums/{id}")
    suspend fun getAlbum(@Path("id") id: Int): Response<AlbumItem>

    @POST("/albums")
    suspend fun uploadAlbum(@Body album: AlbumItem): Response<AlbumItem>
}