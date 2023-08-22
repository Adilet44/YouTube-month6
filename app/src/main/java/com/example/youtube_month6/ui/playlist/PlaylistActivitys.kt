package com.example.youtube_month6.ui.playlist

import androidx.lifecycle.ViewModelProvider
import com.example.youtube_month6.base.BaseActivity
import com.example.youtube_month6.base.BaseViewModel
import com.example.youtube_month6.databinding.ActivityPlaylistsBinding
import com.example.youtube_month6.model.Item
import com.example.youtube_month6.ui.playlist.adapter.PlaylistAdapter

class PlaylistsActivity : BaseActivity<ActivityPlaylistsBinding, BaseViewModel>() {

    private var adapter = PlaylistAdapter(this::onClick)

    private fun onClick(item: Item) {

    }

    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }

    override fun initViewModel() {

        viewModel.playlists().observe(this) {
            binding.recyclerView.adapter = adapter

            adapter.setList(it.items)
        }
    }

    override fun inflateViewBinding(): ActivityPlaylistsBinding {
        return ActivityPlaylistsBinding.inflate(layoutInflater)
    }
}