package com.example.weather.features.home.data.api

import android.util.Log
import com.example.weather.core.API_KEY
import com.example.weather.core.KEY
import okhttp3.Interceptor
import okhttp3.Response

const val INTERCEPTOR = "ServiceInterceptor: Request "

object ServiceInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        Log.d(INTERCEPTOR, request.url().toString())
        val url = request.url().newBuilder().addQueryParameter(KEY, API_KEY).build()
        val newRequest =
            request.newBuilder()
                .url(url)
                .build()
        val response = chain.proceed(newRequest)
        Log.d(INTERCEPTOR, response.code().toString())
        return response
    }
}
