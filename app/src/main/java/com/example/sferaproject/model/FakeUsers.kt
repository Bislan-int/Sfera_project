package com.example.sferaproject.model

import com.github.javafaker.Faker

class FakeUsers {

    private val faker = Faker.instance()

    private val images = mutableListOf(
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

    fun addUsers(position: Int): List<UserModel> {
        images.shuffle()
        return when (position) {
            0 -> {
                (1..40).map {
                    UserModel(
                        image = images[it % images.size],
                        name = faker.name().fullName(),
                        id = it,
                        isSubscribe = it % 3 == 0
                    )
                }
            }
            1 -> {
                (1..40).map {
                    UserModel(
                        image = images[it % images.size],
                        name = faker.name().fullName(),
                        id = it,
                        isSubscribe = true
                    )
                }
            }
            else -> {(1..40).map {
                UserModel(
                    image = images[it % images.size],
                    name = faker.name().fullName(),
                    id = it,
                    isSubscribe = true
                )
            }}
        }
    }
}