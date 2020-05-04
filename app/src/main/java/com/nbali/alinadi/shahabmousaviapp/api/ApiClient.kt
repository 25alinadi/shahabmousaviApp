package com.nbali.alinadi.shahabmousaviapp.api

import com.nbali.alinadi.shahabmousaviapp.utils.Utils
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object{
        var retrofit:Retrofit? = null
        private val BASE_URL = "http://192.168.1.6/shahabmousavi/"

        fun getClient():Retrofit{
            if( retrofit == null){
                var okHttpClient = OkHttpClient().newBuilder()
                    .addInterceptor(Interceptor {
                        var oldRequest = it.request()
                        var newRequestBuilder = oldRequest.newBuilder()
                        if (Utils.myToken != "") {
                            newRequestBuilder.addHeader("token", Utils.myToken)
                        }

                        newRequestBuilder.addHeader("Accept", "application/json")
                        newRequestBuilder.method(oldRequest.method(), oldRequest.body())
                        return@Interceptor it.proceed(newRequestBuilder.build())

                    }).build()
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
            }

            return retrofit!!
        }
    }
}