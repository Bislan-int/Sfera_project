package com.example.sferaproject.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sferaproject.R
import com.example.sferaproject.databinding.ItemUserBinding
import com.example.sferaproject.model.UserModel

class UsersAdapter : ListAdapter<UserModel, UsersAdapter.UserHolder>(Comparator()) {

    private var onItemClickListener: ((UserModel) -> Unit)? = null

    fun setOnItemClickListener(user: (UserModel) -> Unit) {
        onItemClickListener = user
    }

    inner class UserHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemUserBinding.bind(view)
        fun bind(item: UserModel) = with(binding) {
            nameUser.text = item.name
            Glide.with(itemView.context)
                .load(item.image)
                .circleCrop()
                .centerCrop()
                .into(imageUser)

            if (item.isSubscribe) {
                subscribe.text = itemView.context.resources.getText(R.string.subscribe)
                subscribe.setTextColor(itemView.context.resources.getColor(R.color.secondary_color))
            } else {
                subscribe.text = itemView.context.resources.getText(R.string.unsubscribe)
                subscribe.setTextColor(itemView.context.resources.getColor(R.color.white_60))
            }

            subscribe.setOnClickListener {
                onItemClickListener?.let { click ->
                    click(
                        UserModel(
                            id = item.id,
                            name = item.name,
                            isSubscribe = !item.isSubscribe,
                            image = item.image
                        )
                    )
                }
            }
        }
    }

    class Comparator : DiffUtil.ItemCallback<UserModel>() {
        override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
            return oldItem == newItem
        }

        override fun getChangePayload(oldItem: UserModel, newItem: UserModel): Any? {
            return if (oldItem.isSubscribe != newItem.isSubscribe) true else null
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserHolder(view)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind(getItem(position))
    }
}