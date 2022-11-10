package com.example.sferaproject.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sferaproject.databinding.FragmentSubscriptionsBinding
import com.example.sferaproject.model.UserModel
import com.example.sferaproject.view.adapters.UsersAdapter
import com.example.sferaproject.viewmodel.PeopleViewModel

class SubscriptionsFragment : Fragment() {
    private lateinit var binding: FragmentSubscriptionsBinding
    private lateinit var adapter: UsersAdapter
    private val mViewModel: PeopleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSubscriptionsBinding.inflate(inflater, container, false)
        initRecyclerView()
        mViewModel.getSubscriptions()
        itemClick()
        return binding.root
    }

    private fun initRecyclerView() = with(binding) {
        adapter = UsersAdapter()
        mViewModel.apply {
            subscriptions.observe(viewLifecycleOwner) {
                recyclerView.layoutManager = LinearLayoutManager(activity)
                recyclerView.adapter = adapter
                adapter.submitList(it)
                Log.d("MyLog", "List: $it")
            }
        }
    }

    private fun itemClick() {
        adapter.setOnItemClickListener { user ->
            val newList = mutableListOf<UserModel>()
            val oldList = adapter.currentList
            oldList.forEach { oldItem ->
                if (oldItem.id == user.id) {
                    newList.add(user)
                } else {
                    newList.add(oldItem)
                }
            }
            adapter.submitList(newList)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SubscriptionsFragment()
    }
}