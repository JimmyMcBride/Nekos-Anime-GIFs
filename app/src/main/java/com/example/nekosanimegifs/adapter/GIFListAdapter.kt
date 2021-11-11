package com.example.nekosanimegifs.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nekosanimegifs.databinding.GifViewBinding
import com.example.nekosanimegifs.extentions.layoutInflater
import com.example.nekosanimegifs.extentions.loadUrl
import com.example.nekosanimegifs.models.AnimeGIFList
import com.example.nekosanimegifs.models.Url

class GIFListAdapter(
    private val gifList: List<Url>,
    private val gifSelected: (Url) -> Unit
) : RecyclerView.Adapter<GIFListAdapter.GIFListViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ) = GIFListViewHolder.getInstance(parent)

    override fun onBindViewHolder(holder: GIFListViewHolder, position: Int) {
        gifList[position].let { gif ->
            holder.itemView.setOnClickListener { gifSelected(gif) }
            holder.bind(gif)
        }
    }

    override fun getItemCount() = gifList.size

    class GIFListViewHolder(
        private val binding: GifViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(gifInfo: Url) = with(binding) {
            ivAnimeGif.loadUrl(gifInfo.url)
        }

        companion object {
            fun getInstance(parent: ViewGroup) = GifViewBinding.inflate(
                parent.layoutInflater, parent, false
            ).run { GIFListViewHolder(this) }
        }
    }
}