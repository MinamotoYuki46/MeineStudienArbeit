package com.example.apitest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface APIService {
    @GET("/helloworld")
    suspend fun getMessage(): MsgResponseModel
}

object APIClient{
    const val BASE_URL = "https://meineapitest.free.beeceptor.com"

    val api_service: APIService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }
}