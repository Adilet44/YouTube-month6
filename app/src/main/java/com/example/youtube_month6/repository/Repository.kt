package com.example.youtube_month6.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.youtube_month6.BuildConfig
import com.example.youtube_month6.model.PlayLists
import com.example.youtube_month6.model.PlaylistItem
import com.example.youtube_month6.remote.ApiService
import com.example.youtube_month6.remote.RemoteDataSource
import com.example.youtube_month6.remote.RetrofitClient
import com.example.youtube_month6.result.Resource
import kotlinx.coroutines.Dispatchers
import retrofit2.Call
import retrofit2.Response

class Repository {

    private val dataSource: RemoteDataSource by lazy {
        RemoteDataSource()
    }

    fun getPlayLists(): LiveData<Resource<PlayLists>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.loading())
            val response = dataSource.getPlayLists()
            emit(response)
        }
    }

    fun getDetail(playlistId: String): LiveData<Resource<PlaylistItem>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.loading())
            val response = dataSource.getDetail(playlistId)
            emit(response)
        }
    }
}