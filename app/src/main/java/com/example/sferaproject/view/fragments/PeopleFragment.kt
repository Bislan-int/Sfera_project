package com.example.sferaproject.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.sferaproject.R
import com.example.sferaproject.databinding.FragmentPeopleBinding
import com.example.sferaproject.view.adapters.ViewPagerAdapter
import com.example.sferaproject.viewmodel.PeopleViewModel
import com.google.android.material.tabs.TabLayoutMediator

class PeopleFragment : Fragment() {
    private lateinit var binding: FragmentPeopleBinding
    private val mViewModel: PeopleViewModel by viewModels()

    private val fragmentList = listOf(
        SubscribersFragment.newInstance(),
        SubscriptionsFragment.newInstance(),
        MutuallyFragment.newInstance()
    )
    private val titleList = listOf(
        "SUBSCRIBERS",
        "SUBSCRIPTIONS",
        "MUTUALLY"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPeopleBinding.inflate(inflater, container, false)
        initToolBar()
        initViewPagerAdapter()
        search()
        return binding.root
    }

    private fun initToolBar() {
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbarPeople.setupWithNavController(navController, appBarConfiguration)
        binding.toolbarPeople.title = "People"
    }

    private fun initViewPagerAdapter() {
        val adapter = ViewPagerAdapter(activity as FragmentActivity, fragmentList)
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) {
                tab, positions -> tab.text = titleList[positions]
        }.attach()
    }

    private fun search() {

        val searchView = binding.toolbarPeople.menu.findItem(R.id.search).actionView as SearchView
        searchView.queryHint = context?.getString(R.string.search)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                mViewModel.text.value = newText
                return true
            }

        })
    }
}