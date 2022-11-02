package com.example.sferaproject.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sferaproject.R
import com.example.sferaproject.databinding.ItemUserBinding
import com.example.sferaproject.model.UserModel

class PeopleAdapter(private val context: Context) : RecyclerView.Adapter<PeopleAdapter.PeopleHolder>() {

    class PeopleHolder(val binding : ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(inflater, parent, false)
        return PeopleHolder(binding)
    }

    override fun onBindViewHolder(holder: PeopleHolder, position: Int) {
        val person = personList[position]
        with(holder.binding) {
            nameUser.text = person.name
            if (person.isSubscribe) {
                subscribe.text = context.resources.getText(R.string.subscribe)
                subscribe.setTextColor(context.resources.getColor(R.color.secondary_color))
            } else {
                subscribe.text = context.resources.getText(R.string.unsubscribe)
                subscribe.setTextColor(context.resources.getColor(R.color.white_60))
            }

            Glide.with(context)
                .load(person.image)
                .circleCrop()
                .centerCrop()
                .into(imageUser)

            subscribe.setOnClickListener {
                onItemClickListener?.let { click ->
                    click(position)
                }
            }
        }
    }

    private var onItemClickListener: ((Int) -> Unit)? = null

    fun setOnItemClickListener(position: (Int) -> Unit) {
        onItemClickListener = position
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    private val diffCallback = object : DiffUtil.ItemCallback<UserModel>() {
        override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var personList: List<UserModel>
        get() = differ.currentList
        set(value) = differ.submitList(value)
}