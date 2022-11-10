package com.example.sferaproject.model.repository

import com.example.sferaproject.model.UserModel

interface UsersRepository {
    fun getSubscribers(): List<UserModel>
    fun getSubscriptions(): List<UserModel>
    fun getMutually(): List<UserModel>
}