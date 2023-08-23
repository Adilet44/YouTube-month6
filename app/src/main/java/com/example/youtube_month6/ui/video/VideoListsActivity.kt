package com.example.youtube_month6.ui.video

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtube_month6.core.base.BaseActivity
import com.example.youtube_month6.databinding.ActivityVideoListBinding
import com.example.youtube_month6.ui.video.adapter.VideoListAdapter

class VideoListsActivity : BaseActivity<ActivityVideoListBinding, VideoListViewModel>() {
    override fun inflateViewBinding(): ActivityVideoListBinding {
        return ActivityVideoListBinding.inflate(layoutInflater)
    }

    private lateinit var adapter: VideoListAdapter

    override val viewModel: VideoListViewModel by lazy {
        ViewModelProvider(this)[VideoListViewModel::class.java]
    }

    @SuppressLint("SetTextI18n")
    override fun initViewModel() {
        super.initViewModel()
        adapter = VideoListAdapter()
        val getId = intent.getStringExtra("id")
        val getTitle = intent.getStringExtra("title")
        val getDesc = intent.getStringExtra("desc")
        val getCount = intent.getIntExtra("count" ,0)

        viewModel.getDetail(getId).observe(this) {
            it.data?.let { it1 -> adapter.addList(it1.items) }
            binding.tvTitle.text = getTitle
            binding.tvDesc.text = getDesc
            binding.tvCounterVideo.text = "$getCount video series"
        }
    }

    override fun initView() {
        super.initView()
        adapter = VideoListAdapter()
        binding.rvDetail.layoutManager = LinearLayoutManager(this)
        binding.rvDetail.adapter = adapter
    }

    override fun initListener() {
        super.initListener()
        binding.backTv.setOnClickListener { finish() }
    }


}