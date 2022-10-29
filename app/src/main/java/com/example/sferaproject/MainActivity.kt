package com.example.sferaproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.sferaproject.adapters.ChroniclesAdapter
import com.example.sferaproject.adapters.MomentsAdapter
import com.example.sferaproject.adapters.ProfilePhotoAdapter
import com.example.sferaproject.databinding.ActivityMainBinding
import com.example.sferaproject.model.ImageModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterProfile: ProfilePhotoAdapter
    private lateinit var adapterChronicles: ChroniclesAdapter
    private lateinit var adapterMoments: MomentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        headerProfile()
        realisationRecycler()
    }

    private fun headerProfile() {
        Glide
            .with(this)
            .load("https://mobimg.b-cdn.net/v3/fetch/d1/d114d147676588f8c97509961ae07fa4.jpeg")
            .into(binding.contentScrolling.imageHeader)

        binding.contentScrolling.nameProfile.text = "Moto Monster"
        binding.contentScrolling.tvRating.text = "5.0"
        binding.contentScrolling.tvLanguages.text = "Russian, Lezgi"
        binding.contentScrolling.tvCity.text = "Russia"
    }

    private fun realisationRecycler() {
        val listProfile = arrayOf(
                ImageModel("https://kartinkin.net/uploads/posts/2022-02/1645377795_2-kartinkin-net-p-moto-kartinki-2.jpg"),
                ImageModel("https://moto-magazine.ru/SPORTEC%20M9%20RR-1.jpg"),
                ImageModel("https://kartinkin.net/uploads/posts/2022-03/1646535309_2-kartinkin-net-p-kartinki-s-mototsiklami-2.jpg"),
                ImageModel("https://synergosmoto.com/system/App/Models/Article/images/000/000/107/original/cd4a04807d3e25f755941b2e93128f3d.jpg")
            )
        adapterProfile = ProfilePhotoAdapter(listProfile)
        binding.contentScrolling.rvMainImages.adapter = adapterProfile

        val listMoments = arrayOf(
            ImageModel("https://kartinkin.net/uploads/posts/2022-02/1645377795_2-kartinkin-net-p-moto-kartinki-2.jpg"),
            ImageModel("https://bikeland.ru/upload/medialibrary/95a/tvvb3un3nwknlltyk13qh1iu5g9rdvht/hus401.png"),
            ImageModel("https://a.d-cd.net/ac6ea72s-960.jpg"),
            ImageModel("https://basetop.ru/wp-content/uploads/2022/03/harley-davidson-sportster-s.jpg"),
            ImageModel("https://img2.akspic.ru/crops/1/1/0/0/7/170011/170011-motocikl-aksessuary_dlya_motociklov-fara-shina-koleso-1080x1920.png"),
            ImageModel("https://vyborok.com/wp-content/uploads/2019/02/prevyu-1.jpg"),
            ImageModel("https://hdpic.club/pic77.php?src=https://hdpic.club/uploads/posts/2021-11/thumbs/1637764004_1-hdpic-club-p-mototsikli-na-avatarku-2.jpg&w=330&h=490&zc=1"),
        )
        adapterMoments = MomentsAdapter(listMoments)
        binding.contentScrolling.rvMoments.adapter = adapterMoments

        val listChronicles = arrayOf(
            ImageModel("https://assets.newatlas.com/dims4/default/82f1e9b/2147483647/strip/true/crop/1620x1080+79+0/resize/1200x800!/quality/90/?url=http%3A%2F%2Fnewatlas-brightspot.s3.amazonaws.com%2Farchive%2F2018-ducati-panigale-v4-s-speciale-81.jpg"),
            ImageModel("https://kartinkin.net/uploads/posts/2022-02/1645455489_1-kartinkin-net-p-mototsikli-kartinki-1.png"),
            ImageModel("https://drmauto.ru/upload/medialibrary/b5a/b5aad04415d992cdadd83ea9ac7f08a2.jpg"),
            ImageModel("https://www.meme-arsenal.com/memes/3e5e292f02bba24bc57ba1e4b7c239d0.jpg"),
            ImageModel("https://i.pinimg.com/736x/11/e0/32/11e03231e2fed60e1ccb73ed3dfe3205.jpg"),
            ImageModel("https://zastavok.net/main/motocycles/159709974197.jpg"),
            ImageModel("https://motoxmoto.ru/wp-content/uploads/2018/09/35615-1024x768.jpg"),
            ImageModel("https://trendymen.ru/images/article1/119530/attachments/2.jpg"),
            ImageModel("https://topkarting.ru/wp-content/uploads/2019/07/Motocikl-Yamaha-R1-4-e1563777198847.jpg"),
            ImageModel("https://mobimg.b-cdn.net/v3/fetch/02/0237526a7b4c2c75610489345d91b55f.jpeg"),
            ImageModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQM0dnETuCPABoGbMuY1fVJNpNDAnO45oDNCg&usqp=CAU"),
            ImageModel("https://cemeco.ru/wp-content/uploads/2019/02/2018-Yamaha-YZF-R1-2.jpg"),
        )
        adapterChronicles = ChroniclesAdapter(listChronicles)
        binding.contentScrolling.rvChronicles.adapter = adapterChronicles
    }
}