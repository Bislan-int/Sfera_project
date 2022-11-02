package com.example.sferaproject.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sferaproject.databinding.FragmentPeopleBinding
import com.example.sferaproject.model.UserModel
import com.example.sferaproject.view.adapters.PeopleAdapter
import com.github.javafaker.Faker

class PeopleFragment : Fragment() {
    private lateinit var binding: FragmentPeopleBinding
    private lateinit var adapterUser: PeopleAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPeopleBinding.inflate(inflater, container, false)
        initToolBar()
        initRecyclerView()
        initAdapterClickListener()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterUser.personList = addUsers()
    }

    private fun initToolBar() {
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbarPeople.setupWithNavController(navController, appBarConfiguration)
        binding.toolbarPeople.title = "People"
    }

    private fun addUsers(): List<UserModel> {
        val faker = Faker.instance()
        return (1..40).map {
            UserModel(
                image = IMAGES[it % IMAGES.size],
                name = faker.name().fullName(),
                id = it,
                isSubscribe = false
            )
        }
    }

    private fun initRecyclerView() {
        val recyclerView = binding.rvPeople
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        adapterUser = PeopleAdapter(requireContext())
        recyclerView.adapter = adapterUser
        val itemAnimator = binding.rvPeople.itemAnimator
        if (itemAnimator is DefaultItemAnimator)
            itemAnimator.supportsChangeAnimations = false
    }

    private fun initAdapterClickListener() {
        adapterUser.setOnItemClickListener { position ->
            val list = adapterUser.personList.toMutableList()
             val user = list[position]
            list[position] = UserModel(
                image = user.image,
                name = user.name,
                id = user.id,
                isSubscribe = !user.isSubscribe
            )
            adapterUser.personList = list
        }
    }

    companion object {
        private val IMAGES = mutableListOf(
            "https://meragor.com/files/styles//220_220_bottom_wm/_5_5.jpg",
            "https://meragor.com/files/styles//220_220_bottom_wm/2_4.jpg",
            "https://meragor.com/files/styles//220_220_bottom_wm/1_7.jpg",
            "https://meragor.com/files/styles//220_220_bottom_wm/6_2.jpg",
            "https://meragor.com/files/styles//220_220_bottom_wm/_1_27.jpg",
            "https://meragor.com/files/styles//220_220_bottom_wm/5_15.jpg",
            "https://meragor.com/files/styles//220_220_bottom_wm/10_2.jpg",
            "https://meragor.com/files/styles//220_220_bottom_wm/6_0.jpg",
            "https://meragor.com/files/styles//220_220_bottom_wm/5_3.jpg",
            "https://meragor.com/files/styles//220_220_bottom_wm/1_2_0.jpg"
        )
    }
}