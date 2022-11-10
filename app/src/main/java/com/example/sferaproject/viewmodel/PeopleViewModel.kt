package com.example.sferaproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sferaproject.model.UserModel
import com.example.sferaproject.model.repository.UsersRepository
import com.example.sferaproject.model.repository.UsersRepositoryImpl

class PeopleViewModel: ViewModel() {

    private val mUsersRepository: UsersRepository = UsersRepositoryImpl()

    private val _subscribers = MutableLiveData<List<UserModel>>()
    val subscribers : LiveData<List<UserModel>> = _subscribers

    private val _subscriptions = MutableLiveData<List<UserModel>>()
    val subscriptions : LiveData<List<UserModel>> = _subscriptions

    private val _mutually = MutableLiveData<List<UserModel>>()
    val mutually : LiveData<List<UserModel>> = _mutually

    var text = MutableLiveData("")

    fun getSubscribers() {
        val users = mUsersRepository.getSubscribers()
        if (text.value == "") {
            _subscribers.postValue(users)
        }else {
            val result = users.filter {
                it.name.lowercase().contains(text.value!!.lowercase())
            }
            _subscribers.postValue(result)
        }
    }

    fun getSubscriptions() {
        val users = mUsersRepository.getSubscriptions()
        _subscriptions.postValue(users)
    }

    fun getMutually() {
        val users = mUsersRepository.getMutually()
        _mutually.postValue(users)
    }
}