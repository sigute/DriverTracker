package com.github.sigute.tracker.di

import android.content.Context
import com.github.sigute.tracker.api.HeaderInterceptor
import com.github.sigute.tracker.api.TreckerService
import com.github.sigute.tracker.utils.AuthPreferences
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class TrackerModule(val context: Context) {
    @Provides
    @Singleton
    internal fun provideTreckerService(retrofit: Retrofit): TreckerService {
        return retrofit.create(TreckerService::class.java)
    }

    @Provides
    @Singleton
    internal fun provideAuthPreferences(): AuthPreferences {
        return AuthPreferences(context)
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(authPreferences: AuthPreferences): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(HeaderInterceptor(authPreferences))
        return httpClient.build()
    }

    @Provides
    @Singleton
    internal fun providesRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://mytime.trecker.com/api/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
    }
}
