package com.github.sigute.tracker.api

import com.github.sigute.tracker.utils.AuthPreferences
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor(private val authPreferences: AuthPreferences) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()

        authPreferences.token?.let {
            request.addHeader("Authorization", it)
        }

        return chain.proceed(request.build())
    }
}
