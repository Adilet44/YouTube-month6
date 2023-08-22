package com.example.youtube_month6.ui.video

import android.widget.Toast
import com.example.youtube_month6.base.BaseActivity
import com.example.youtube_month6.base.BaseViewModel
import com.example.youtube_month6.databinding.ActivityVideoListBinding
import com.example.youtube_month6.ui.playlist.PlaylistsActivity

class VideoListsActivity(override val viewModel: BaseViewModel) : BaseActivity<ActivityVideoListBinding, BaseViewModel>() {
    override fun inflateViewBinding(): ActivityVideoListBinding {
        return ActivityVideoListBinding.inflate(layoutInflater)
    }

}