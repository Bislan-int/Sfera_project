package com.example.sferaproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sferaproject.databinding.ItemMainImageBinding

class ProfilePhotoAdapter(private val listImages: Array<DataImage>) : RecyclerView.Adapter<ProfilePhotoAdapter.PhotoAdapterHolder>() {

    class PhotoAdapterHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ItemMainImageBinding.bind(item)
        fun bind(item: DataImage) {
            Glide
                .with(itemView.context)
                .load(item.image)
                .into(binding.imageProfile)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoAdapterHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main_image, parent, false)
        return PhotoAdapterHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoAdapterHolder, position: Int) {
        holder.bind(listImages[position])
    }

    override fun getItemCount(): Int {
        return 4
    }
}