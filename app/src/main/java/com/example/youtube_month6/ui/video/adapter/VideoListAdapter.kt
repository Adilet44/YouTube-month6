package com.example.youtube_month6.ui.video.adapter

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube_month6.core.ext.loadImage
import com.example.youtube_month6.databinding.ItemPlaylistsBinding
import com.example.youtube_month6.model.PlaylistItem

class VideoListAdapter(): RecyclerView.Adapter<VideoListAdapter.PlaylistItemViewHolder>() {
    private var data = listOf<PlaylistItem.Item>()

    @SuppressLint("NotifyDataSetChanged")
    fun addList(list: List<PlaylistItem.Item?>?) {
        this.data = list as List<PlaylistItem.Item>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistItemViewHolder {
        return PlaylistItemViewHolder(
            ItemPlaylistsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: PlaylistItemViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class PlaylistItemViewHolder(private val binding: ItemPlaylistsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PlaylistItem.Item) {
            binding.image.loadImage(item.snippet?.thumbnails?.high?.url!!)
            binding.tvTitle.text = item.snippet.title
        }
    }
}