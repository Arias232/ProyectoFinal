package com.example.ProyectoFinal.retrofit;

import com.example.ProyectoFinal.R
import com.example.ProyectoFinal.common.Constantes
import com.example.ProyectoFinal.common.MyApp
import okhttp3.Interceptor
import okhttp3.Response

class TheMovieDBInterceptor: Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {


        val urlWithParams = chain.request()
            .url
            .newBuilder()
            .addQueryParameter(Constantes.URL_PARAM_API_KEY, Constantes.API_KEY)
            .addQueryParameter(Constantes.URL_PARAM_LANGUAGE, MyApp.instance.getString(R.string.language)
            )
            .build()

        var request = chain.request()
        request = request?.newBuilder()
            .url(urlWithParams)
            ?.addHeader("Content-Type", "application/json")
            ?.addHeader("Accept", "application/json")
            ?.build()
        return chain.proceed(request)
    }
}