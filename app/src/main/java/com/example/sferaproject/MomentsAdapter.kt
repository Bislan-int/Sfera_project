package com.example.sferaproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sferaproject.databinding.ItemMomentsImageBinding

class MomentsAdapter(private val listImages: Array<DataImage>) : RecyclerView.Adapter<MomentsAdapter.MomentsHolder>() {


    class MomentsHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ItemMomentsImageBinding.bind(item)
        fun bind(item: DataImage) {
            Glide
                .with(itemView.context)
                .load(item.image)
                .into(binding.imageMoments)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MomentsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_moments_image, parent, false)
        return MomentsHolder(view)
    }

    override fun onBindViewHolder(holder: MomentsHolder, position: Int) {
        holder.bind(listImages[position])
    }

    override fun getItemCount(): Int {
        return listImages.size
    }
}