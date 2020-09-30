package com.muthu.mvvm.repo

import com.muthu.mvvm.network.AuthApi

class AuthRepo(
    private val api: AuthApi
) : BaseRepo() {

    suspend fun login(
        email: String,
        password: String
    ) = safeApiCall {
        api.login(email, password)
    }
}