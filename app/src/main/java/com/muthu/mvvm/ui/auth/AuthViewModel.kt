package com.muthu.mvvm.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muthu.mvvm.model.LoginResponse
import com.muthu.mvvm.network.Resource
import com.muthu.mvvm.repo.AuthRepo
import kotlinx.coroutines.launch

class AuthViewModel(
    private val repo: AuthRepo
) : ViewModel() {
    private val _loginResponse: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()


    val loginResponse: LiveData<Resource<LoginResponse>>

    get() = _loginResponse

     fun userLogin(email: String, password: String) = viewModelScope.launch {
        _loginResponse.value = repo.login(email, password)
    }


}