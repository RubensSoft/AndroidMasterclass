package com.example.androidmasterclass.data.repository.artist

import com.example.androidmasterclass.data.model.artist.Artist
import com.example.androidmasterclass.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.androidmasterclass.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.androidmasterclass.data.repository.artist.datasource.ArtistRemoteDatasource
import com.example.androidmasterclass.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDatasource: ArtistRemoteDatasource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
       return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtist = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtist)
        artistCacheDataSource.saveArtistsToCache(newListOfArtist)
        return newListOfArtist
    }

    private suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>
        artistRemoteDatasource.getArtists().body()?.let {
            artistList = it.artists
        }
        return artistList
    }

    private suspend fun getArtistsFromDB():List<Artist>{
        var artistList = artistLocalDataSource.getArtistsFromDB()
        when (artistList.size) {
            0 -> artistList = getArtistsFromAPI()
            else -> return artistList
        }
        return artistList
    }

    private suspend fun getArtistsFromCache():List<Artist>{
        var artistList = artistCacheDataSource.getArtistsFromCache()
        when(artistList.size) {
            0 -> {
                artistList = getArtistsFromDB()
                artistCacheDataSource.saveArtistsToCache(artistList)
            }
            else -> return artistList
        }
        return artistList
    }
}