package com.example.foodapplication.utils.di

import com.example.foodapplication.data.server.ApiService
import com.example.foodapplication.utils.BASE_URL
import com.example.foodapplication.utils.TIME_OUT
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ApiModule {


    @Provides
    @Singleton
    fun provideBaseUrl()= BASE_URL


    @Provides
    @Singleton
    fun provideTimeOut()= TIME_OUT

    @Provides
    @Singleton
    fun provideInterceptor()=HttpLoggingInterceptor().apply {

        level=HttpLoggingInterceptor.Level.BODY
    }


    @Provides
    @Singleton
    fun provideGson():Gson=GsonBuilder().setLenient().create()

    @Provides
    @Singleton
    fun provideApiClient(time:Long,bodyInterceptor:HttpLoggingInterceptor)=OkHttpClient.Builder()
        .writeTimeout(time,TimeUnit.SECONDS)
        .connectTimeout(time,TimeUnit.SECONDS)
        .readTimeout(time,TimeUnit.SECONDS)
        .addInterceptor(bodyInterceptor)
        .retryOnConnectionFailure(true)
        .build()


    @Provides
    @Singleton
    fun provideRetrofit(url:String,gson:Gson,client:OkHttpClient):ApiService=Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .client(client)
        .build()
        .create(ApiService::class.java)





}