package com.itis.androidsummerpractice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.itis.androidsummerpractice.databinding.ItemPlayerBinding

class PlayerAdapter(
    private var list: List<Player>,
    private val glide: RequestManager,
    private val onItemClick: (Player) -> Unit,
) : RecyclerView.Adapter<PlayerItem>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlayerItem = PlayerItem(
        binding = ItemPlayerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        ),
        glide = glide,
        onItemClick = onItemClick
    )

    override fun onBindViewHolder(holder: PlayerItem, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}
