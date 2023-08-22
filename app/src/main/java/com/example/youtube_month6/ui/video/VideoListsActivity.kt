package com.example.youtube_month6.ui.video

import androidx.lifecycle.ViewModelProvider
import com.example.youtube_month6.core.base.BaseActivity
import com.example.youtube_month6.core.base.BaseViewModel
import com.example.youtube_month6.databinding.ActivityVideoListBinding

class VideoListsActivity() : BaseActivity<ActivityVideoListBinding, BaseViewModel>() {
    override fun inflateViewBinding(): ActivityVideoListBinding {
        return ActivityVideoListBinding.inflate(layoutInflater)
    }

    override val viewModel: BaseViewModel by lazy {
        ViewModelProvider(this)[BaseViewModel::class.java]
    }

}