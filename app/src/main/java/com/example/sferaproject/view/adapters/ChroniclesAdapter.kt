package com.example.sferaproject.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sferaproject.model.ImageModel
import com.example.sferaproject.R
import com.example.sferaproject.databinding.ItemChroniclesImageBinding

class ChroniclesAdapter(private val listImages: List<ImageModel>) : RecyclerView.Adapter<ChroniclesAdapter.ChroniclesHolder>() {


    class ChroniclesHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ItemChroniclesImageBinding.bind(item)
        fun bind(item: ImageModel) {
            Glide
                .with(itemView.context)
                .load(item.image)
                .into(binding.imageChronicles)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChroniclesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chronicles_image, parent, false)
        return ChroniclesHolder(view)
    }

    override fun onBindViewHolder(holder: ChroniclesHolder, position: Int) {
        holder.bind(listImages[position])
    }

    override fun getItemCount(): Int {
        return listImages.size
    }
}