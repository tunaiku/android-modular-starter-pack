package com.godohdev.networkmodule.di

import android.os.SystemClock
import android.util.Log
import com.godohdev.networkmodule.BuildConfig
import com.godohdev.networkmodule.api.MoviesService
import com.godohdev.networkmodule.api.TvShowService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.Dispatcher
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


/**
 *
 * Created by Wahyu Permadi on 2019-12-13.
 * Android Engineer
 *
 **/

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun gson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient{
        val httpInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
            Log.d("Response-Api", it)
        })

        val dispatcher = Dispatcher()
        dispatcher.maxRequests = 1

        val interceptor = Interceptor { chain ->
            SystemClock.sleep(1000)
            chain.proceed(chain.request())
        }

        httpInterceptor.level = HttpLoggingInterceptor.Level.BASIC

        return OkHttpClient.Builder().addInterceptor(httpInterceptor)
            .addNetworkInterceptor(interceptor)
            .dispatcher(dispatcher)
            .build()
    }

    @Provides
    @Singleton
    fun provideRestClient(okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun moviesService(retrofit: Retrofit): MoviesService{
        return retrofit.create(MoviesService::class.java)
    }

    @Provides
    @Singleton
    fun tvShowService(retrofit: Retrofit): TvShowService{
        return retrofit.create(TvShowService::class.java)
    }
}