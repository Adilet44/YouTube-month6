package com.example.youtube_month6.remote

import com.example.youtube_month6.model.PlayLists
import com.example.youtube_month6.model.PlaylistItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("playlists")
    suspend fun getPlayLists(
        @Query("key") key: String,
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("maxResults") maxResults: Int = 20
    ): Response<PlayLists>

//    @GET("playlistItems")
//    suspend fun playlistItems(
//        @Query("key") key: String,
//        @Query("part") part: String,
//        @Query("playlistId") channelId: String,
//        @Query("maxResults") maxResults: Int = 30
//    ): Response<PlaylistItem>
}