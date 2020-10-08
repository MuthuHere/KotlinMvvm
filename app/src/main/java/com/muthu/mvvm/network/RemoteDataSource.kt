package com.muthu.mvvm.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource {
    companion object {
        private const val BASE_URL = "https://simplifiedcoding.tech/mywebapp/public/api/"
    }

    fun <Api> buildApi(
        api: Class<Api>
    ): Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().also { client ->
                val httpLogging = HttpLoggingInterceptor()
                httpLogging.setLevel(HttpLoggingInterceptor.Level.BODY)
                client.addInterceptor(httpLogging)
            }.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }
}