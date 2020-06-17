package com.example.vadsofttest.model

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val base_url="https://5e99a9b1bc561b0016af3540.mockapi.io/"

    private val okHttpClient= OkHttpClient.Builder()
        .addInterceptor { chain->

            val original=chain.request()
            val requestBuilder=original.newBuilder()
                .addHeader("Authorization","")
                .method(original.method(),original.body())
            val request=requestBuilder.build()
            chain.proceed(request)
        }.build()

    val instance: API by lazy {
        var retrofit= Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient)
            .build()
        retrofit.create(API::class.java)
    }
}