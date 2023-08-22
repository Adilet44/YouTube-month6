package com.example.youtube_month6.remote

import com.example.youtube_month6.BuildConfig
import com.example.youtube_month6.core.network.BaseDataSource
import com.example.youtube_month6.model.PlayLists
import com.example.youtube_month6.model.PlaylistItem
import com.example.youtube_month6.result.Resource
import com.example.youtube_month6.utils.Const

class RemoteDataSource : BaseDataSource() {
    private val apiService: ApiService = RetrofitClient.create()

    suspend fun getPlayLists(): Resource<PlayLists> = getResult {
            apiService.getPlayLists(
                BuildConfig.API_KEY,
                Const.part,
                Const.channelId
            )
        }
    }

    suspend fun getDetail(playlistId: String):Resource<PlaylistItem> = getResult {
            apiService.playlistItems(
                BuildConfig.API_KEY,
                Const.part,
                playlistId,
                30
            )
        }
    }
}