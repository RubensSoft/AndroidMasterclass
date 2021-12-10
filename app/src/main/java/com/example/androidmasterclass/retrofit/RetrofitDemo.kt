package com.example.androidmasterclass.retrofit

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.androidmasterclass.R
import retrofit2.Response

class RetrofitDemo : AppCompatActivity() {

    private lateinit var retrofitService: AlbumService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_demo)
        retrofitService = RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)
        getRequestWithQueryParameteres()
        getRequestWithPathParameters()
    }

    private fun getRequestWithQueryParameteres() {
        val responseLiveData : LiveData<Response<Albums>> = liveData {
//            val response = retrofitService.getAlbums()
            val response = retrofitService.getSortedAlbums(userId = 3)
            emit(response)
        }
        responseLiveData.observe(this, {
            val albumList = it.body()?.listIterator()
            albumList?.let {
                while (albumList.hasNext()) {
                    val albumItem = albumList.next()
                    val result = "Album Title : ${albumItem.title}\n" +
                        "Album Id : ${albumItem.id}\n" +
                        "User Id : ${albumItem.userId}\n\n\n"
                    findViewById<TextView>(R.id.textView_retrofitDemo).append(result)
                }
            }
        })
    }

    private fun getRequestWithPathParameters() {
        val pathResponse : LiveData<Response<AlbumItem>> = liveData {
            val response = retrofitService.getAlbum(3)
            emit(response)
        }
        pathResponse.observe(this, {
            val title = it.body()?.title
            findViewById<TextView>(R.id.textView_retrofitDemo).append(title)
        })
    }
}