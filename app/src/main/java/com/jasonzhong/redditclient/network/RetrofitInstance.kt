package com.jasonzhong.redditclient.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jasonzhong.redditclient.util.Constant

import java.io.IOException
import java.util.concurrent.TimeUnit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private var retrofit: Retrofit? = null

    /**
     * Create an instance of Retrofit object
     */
    // Customize the request
    // Customize or return the response
    //Only for debugging and testing purpose, should be removed for production.
    // set your desired log level
    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                val httpClient = OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS)
                        .connectTimeout(30, TimeUnit.SECONDS)

                httpClient.addInterceptor { chain ->
                    val original = chain.request()
                    val request = original.newBuilder()
                            .header("Accept", "application/json")
                            .header("Authorization", "auth-token")
                            .method(original.method(), original.body())
                            .build()

                    chain.proceed(request)
                }
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                httpClient.addInterceptor(logging)

                val OkHttpClient = httpClient.build()
                val gson = GsonBuilder()
                        .setLenient()
                        .create()
                retrofit = retrofit2.Retrofit.Builder()
                        .baseUrl(Constant.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build()
            }
            return retrofit
        }
}
