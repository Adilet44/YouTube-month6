package com.example.youtube_month6.ui.playlist

import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.youtube_month6.core.base.BaseActivity
import com.example.youtube_month6.core.base.BaseViewModel
import com.example.youtube_month6.core.network.ConnectionLiveData
import com.example.youtube_month6.databinding.ActivityPlaylistsBinding
import com.example.youtube_month6.model.Item
import com.example.youtube_month6.ui.playlist.adapter.PlaylistAdapter

class PlaylistsActivity : BaseActivity<ActivityPlaylistsBinding, BaseViewModel>() {

    private var adapter = PlaylistAdapter()


    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }

    override fun initViewModel() {

        viewModel.playlists().observe(this) {
            binding.recyclerView.adapter = adapter

            adapter.setList(it.items)
        }
    }

    override fun checkConnection() {
        super.checkConnection()
        ConnectionLiveData(application).observe(this) { isConnected ->
            if (isConnected) {
                binding.noInternetConnection.visibility = View.GONE
                binding.internetConnection.visibility = View.VISIBLE
            } else {
                binding.noInternetConnection.visibility = View.VISIBLE
                binding.internetConnection.visibility = View.GONE
            }
        }
    }

    override fun inflateViewBinding(): ActivityPlaylistsBinding {
        return ActivityPlaylistsBinding.inflate(layoutInflater)
    }
}