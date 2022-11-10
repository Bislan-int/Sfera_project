package com.example.sferaproject.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sferaproject.databinding.FragmentSubscribersBinding
import com.example.sferaproject.model.UserModel
import com.example.sferaproject.view.adapters.UsersAdapter
import com.example.sferaproject.viewmodel.PeopleViewModel

class SubscribersFragment : Fragment() {
    private lateinit var binding: FragmentSubscribersBinding
    private lateinit var adapter: UsersAdapter
    private val mViewModel: PeopleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSubscribersBinding.inflate(inflater, container, false)
        initRecyclerView()
        mViewModel.getSubscribers()
        itemClick()
        return binding.root
    }

    /*override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        val menuItem: MenuItem = menu.findItem(R.id.search)
        val searchView: SearchView = menuItem.actionView as SearchView
        searchView.queryHint = "Type here to search"
        searchView.isIconified = false
        searchView.onActionViewExpanded()
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                if (newText.isEmpty()) {
                    adapter.submitList(adapter.currentList)
                    return true
                }

                val result = adapter.currentList.filter {
                    it.name.toLowerCase(Locale.getDefault()).contains(newText.toLowerCase(Locale.getDefault()))
                }
                adapter.submitList(result)
                return true
            }

        })
        super.onCreateOptionsMenu(menu, inflater)
    }*/

    private fun initRecyclerView() = with(binding) {
        adapter = UsersAdapter()
        mViewModel.apply {
            subscribers.observe(viewLifecycleOwner) {
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
        fun newInstance() = SubscribersFragment()
    }
}