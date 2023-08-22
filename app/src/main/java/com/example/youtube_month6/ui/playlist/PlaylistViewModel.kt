package com.example.youtube_month6.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtube_month6.App
import com.example.youtube_month6.BuildConfig
import com.example.youtube_month6.core.base.BaseViewModel
import com.example.youtube_month6.model.PlayLists
import com.example.youtube_month6.remote.ApiService
import com.example.youtube_month6.remote.RetrofitClient
import com.example.youtube_month6.result.Resource
import retrofit2.Call
import retrofit2.Response

class PlaylistViewModel: BaseViewModel() {

    fun playlists(): LiveData<Resource<PlayLists>>{
        return App.repository.getPlayLists()
    }

}