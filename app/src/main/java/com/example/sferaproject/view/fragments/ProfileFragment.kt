package com.example.sferaproject.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColorStateList
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.sferaproject.R
import com.example.sferaproject.databinding.FragmentProfileBinding
import com.example.sferaproject.model.ImageModel
import com.example.sferaproject.view.adapters.ChroniclesAdapter
import com.example.sferaproject.view.adapters.MomentsAdapter
import com.example.sferaproject.view.adapters.ProfilePhotoAdapter

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var adapterProfile: ProfilePhotoAdapter
    private lateinit var adapterChronicles: ChroniclesAdapter
    private lateinit var adapterMoments: MomentsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigationFragments()
        headerProfile()
        realisationRecycler()
        changeColorCounter()
    }

    private fun changeColorCounter() {
        with(binding.contentScrolling) {
            edText.onFocusChangeListener = View.OnFocusChangeListener { _, isActive ->
                if (isActive) {
                    inputLayoutAboutMe.counterTextColor = getColorStateList(requireContext(), R.color.secondary_color)
                } else {
                    inputLayoutAboutMe.counterTextColor = getColorStateList(requireContext(), R.color.white_60)
                }
            }
        }
    }

    private fun navigationFragments() {
        val controller = findNavController()
        binding.contentScrolling.btPeople.setOnClickListener { controller.navigate(R.id.peopleFragment) }
    }

    private fun headerProfile() {
        Glide
            .with(this)
            .load("https://mobimg.b-cdn.net/v3/fetch/5c/5c6d0a5fb38f4621e61e4980af90fb2d.jpeg?h=900&r=0.5")
            .into(binding.contentScrolling.imageHeader)

        binding.contentScrolling.nameProfile.text = "Moto Monster"
        binding.contentScrolling.tvRating.text = "5.0"
        binding.contentScrolling.tvLanguages.text = "Russian, Lezgi"
        binding.contentScrolling.tvCity.text = "Russia"
    }

    private fun realisationRecycler() {

        val listProfile = listOf(
            ImageModel("https://mobimg.b-cdn.net/v3/fetch/d1/d114d147676588f8c97509961ae07fa4.jpeg?h=900&r=0.5"),
            ImageModel("https://mobimg.b-cdn.net/v3/fetch/97/977b7324ebe13c92982c83e81388c7b7.jpeg?h=900&r=0.5"),
            ImageModel("https://mobimg.b-cdn.net/v3/fetch/89/8963a7922cae40ef5536b5f908e89763.jpeg?h=900&r=0.5"),
            ImageModel("https://mobimg.b-cdn.net/v3/fetch/54/54f65e95c119250e2ba33b03da86856d.jpeg?h=900&r=0.5")
        )
        adapterProfile = ProfilePhotoAdapter(listProfile)
        binding.contentScrolling.rvMainImages.adapter = adapterProfile

        val listMoments = listOf(
            ImageModel("https://mobimg.b-cdn.net/v3/fetch/d3/d384858e7285bff454b303077fbdfa37.jpeg?h=900&r=0.5"),
            ImageModel("https://mobimg.b-cdn.net/v3/fetch/f5/f56f82e82a117f94aec1ed580b06bc9d.jpeg?h=900&r=0.5"),
            ImageModel("https://mobimg.b-cdn.net/v3/fetch/ec/ecd22ee56a0a974ec98903f812277775.jpeg?h=900&r=0.5"),
            ImageModel("https://mobimg.b-cdn.net/v3/fetch/9a/9ae3fd033a80e14090ac707f7fe20ccf.jpeg?h=900&r=0.5"),
            ImageModel("https://mobimg.b-cdn.net/v3/fetch/94/945b1744b0a47eec98c46db149e8799e.jpeg?h=900&r=0.5"),
            ImageModel("https://mobimg.b-cdn.net/v3/fetch/83/8395e519f7ce8acb660b364e0af55796.jpeg?h=900&r=0.5"),
        )
        adapterMoments = MomentsAdapter(listMoments)
        binding.contentScrolling.rvMoments.adapter = adapterMoments

        val listChronicles = listOf(
            ImageModel("https://mobimg.b-cdn.net/v3/fetch/9f/9f28f4d974ae60ecadfdc28a02c4b92a.jpeg?h=900&r=0.5"),
            ImageModel("https://mobimg.b-cdn.net/v3/fetch/cd/cdacf27693c3a2cc3a20c8d47aff427e.jpeg?h=900&r=0.5"),
            ImageModel("https://mobimg.b-cdn.net/v3/fetch/e0/e0be39b0662f1e3aeb83bb8a196e14cc.jpeg?h=900&r=0.5"),
            ImageModel("https://mobimg.b-cdn.net/v3/fetch/e6/e6a04de6e024d7d8fc6311c52c3955c5.jpeg?h=900&r=0.5"),
            ImageModel("https://mobimg.b-cdn.net/v3/fetch/2f/2fad19283e1e77f25b2154b1d058b81c.jpeg?h=900&r=0.5"),
            ImageModel("https://mobimg.b-cdn.net/v3/fetch/fc/fc05ba4f7df330139cb195bcdc40b86b.jpeg?h=900&r=0.5"),
            ImageModel("https://mobimg.b-cdn.net/v3/fetch/a3/a32f8de754b46de4fcefa2a8d6750038.jpeg?h=900&r=0.5"),
            ImageModel("https://mobimg.b-cdn.net/v3/fetch/97/97871e1debf4d695eaea64428f37a753.jpeg?h=900&r=0.5"),
            ImageModel("https://mobimg.b-cdn.net/v3/fetch/69/696b36b6650e88bb9dfcc6ffeff12c3b.jpeg?h=900&r=0.5"),
            ImageModel("https://mobimg.b-cdn.net/v3/fetch/2a/2a78518de490a1d0762ff56789c676f5.jpeg?h=900&r=0.5"),
            ImageModel("https://mobimg.b-cdn.net/v3/fetch/1e/1e84666e896a30a674468370162d17ff.jpeg?h=900&r=0.5"),
            ImageModel("https://mobimg.b-cdn.net/v3/fetch/02/0237526a7b4c2c75610489345d91b55f.jpeg?h=900&r=0.5"),
        )
        adapterChronicles = ChroniclesAdapter(listChronicles)
        binding.contentScrolling.rvChronicles.adapter = adapterChronicles
    }
}