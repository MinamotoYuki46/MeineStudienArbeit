package com.example.treblewinner.data.remote.di

import com.example.treblewinner.data.remote.api.TrebleWinnerAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    // Use this for AVD
    // private const val BASE_URL = "http://10.0.2.2:8000"

    // Use this for physical device
    private const val BASE_URL = "http://192.168.100.141:8000"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideTrebleWinnerAPI(retrofit: Retrofit): TrebleWinnerAPI {
        return retrofit.create(TrebleWinnerAPI::class.java)
    }
}
