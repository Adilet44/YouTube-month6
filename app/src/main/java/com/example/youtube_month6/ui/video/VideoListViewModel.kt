package com.example.youtube_month6.ui.video

import androidx.lifecycle.LiveData
import com.example.youtube_month6.App
import com.example.youtube_month6.core.base.BaseViewModel
import com.example.youtube_month6.model.PlaylistItem
import com.example.youtube_month6.result.Resource

class VideoListViewModel : BaseViewModel() {

    fun getDetail(playListId: String?): LiveData<Resource<PlaylistItem>> {
        return App.repository.getDetail(playListId!!)
    }
}