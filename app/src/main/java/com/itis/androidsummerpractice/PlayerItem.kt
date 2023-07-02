package com.itis.androidsummerpractice

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.itis.androidsummerpractice.databinding.ItemPlayerBinding

class PlayerItem(
    private val binding: ItemPlayerBinding,
    private val glide: RequestManager,
    private val onItemClick: (Player) -> Unit,
) : ViewHolder(binding.root) {

    private val options: RequestOptions = RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.NONE)

    fun onBind(player: Player) {
        binding.run {
            tvTitle.text = player.name
            tvPosition.text = player.position

            glide
                .load(player.url)
                .placeholder(R.drawable.unknown_person)
                .error(R.drawable.img_not_found)
                .apply(options)
                .into(ivImage)

            root.setOnClickListener {
                onItemClick(player)
            }
        }
    }
}
