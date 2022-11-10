package com.example.sferaproject.model.repository

import com.example.sferaproject.model.FakeUsers
import com.example.sferaproject.model.UserModel

class UsersRepositoryImpl: UsersRepository {

    private val listUsers = FakeUsers()

    override fun getSubscribers(): List<UserModel> {
        return listUsers.addUsers(0)
    }

    override fun getSubscriptions(): List<UserModel> {
        return listUsers.addUsers(1)
    }

    override fun getMutually(): List<UserModel> {
        return listUsers.addUsers(2)
    }
}