package com.yazid.assessment3.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yazid.assessment3.repository.LoginRepository

import com.yazid.assessment3.entity.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: LoginRepository) : ViewModel() {

    var getAllUser: LiveData<List<User>> = repository.getAllUser

    fun getOneUser(id: Long): LiveData<User> {
        return repository.getOneUser(id)
    }

    fun getUserByUsername(username: String): LiveData<User> {
        return repository.getUserByUsername(username)
    }

    fun insertUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertUser(user)
    }

    fun updateUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
        repository.updateUser(user)
    }
}