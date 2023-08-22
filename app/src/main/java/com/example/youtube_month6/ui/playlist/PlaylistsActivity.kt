package com.example.youtube_month6.ui.playlist

import android.app.ProgressDialog.show
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.youtube_month6.core.base.BaseActivity
import com.example.youtube_month6.core.base.BaseViewModel
import com.example.youtube_month6.core.network.ConnectionLiveData
import com.example.youtube_month6.databinding.ActivityPlaylistsBinding
import com.example.youtube_month6.model.Item
import com.example.youtube_month6.result.Status
import com.example.youtube_month6.ui.playlist.adapter.PlaylistAdapter
import com.example.youtube_month6.ui.video.VideoListsActivity

class PlaylistsActivity : BaseActivity<ActivityPlaylistsBinding, BaseViewModel>() {

    private var adapter = PlaylistAdapter(this::onClick)


    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }

    override fun initViewModel() {
        super.initViewModel()
        viewModel.loading.observe(this) {
            binding.progressBar.isVisible = it
        }
        viewModel.playlists().observe(this) {
            binding.recyclerView.adapter = adapter
            when (it.status) {
                Status.SUCCESS -> {
                    binding.recyclerView.adapter = adapter
                    it.data?.let { it1 -> adapter.setList(it1.items) }
                    viewModel.loading.postValue(false)
                }
                Status.LOADING -> {
                    viewModel.loading.postValue(true)
                }

                Status.ERROR -> {
                    viewModel.loading.postValue(false)
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
            }
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


    private fun onClick(item: Item) {
        val intent = Intent(this@PlaylistsActivity, VideoListsActivity::class.java)
        intent.putExtra("id", item.id)
        intent.putExtra("title", item.snippet.title)
        intent.putExtra("desc", item.snippet.description)
        intent.putExtra("count", item.contentDetails.itemCount)
        startActivity(intent)
    }
}