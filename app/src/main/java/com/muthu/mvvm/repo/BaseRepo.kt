package com.muthu.mvvm.repo

import com.muthu.mvvm.network.AuthApi
import com.muthu.mvvm.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRepo {

    suspend fun <T> safeApiCall(
        api: suspend () -> T
    ): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(api.invoke())
            } catch (t: Throwable) {
                when (t) {
                    is HttpException -> {
                        Resource.Error(true, t.code(), t.response()?.errorBody())
                    }
                    else -> {
                        Resource.Error(true, null, null)
                    }
                }
            }
        }
    }

}