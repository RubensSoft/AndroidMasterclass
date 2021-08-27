package com.example.androidmasterclass.retrofit

import com.google.gson.annotations.SerializedName

data class AlbumItem(
    @SerializedName(value = "id")
    val id: Int,
    @SerializedName(value = "title")
    val title: String,
    @SerializedName(value = "userId")
    val userId: Int
)
