package com.digel.movieapplication.network

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Network {

    private fun provideLoggingInterceptor(): HttpLoggingInterceptor {

        /**
         * @BODY if you need show all response
         * @BASIC only show end_point response
         * @NONE nothing
         * */
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    private fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .addInterceptor(provideLoggingInterceptor())
            .retryOnConnectionFailure(false)
            .callTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)

        return builder.build()
    }

    private fun provideRetrofit(): Retrofit {

        /**
         * setFieldNamingPolicy()
         * for convert lowercase with underscores
         * json:`user_name`, you can use `userName` as variable
         */
        val gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setLenient()
            .setPrettyPrinting()
            .create()

        val builder = Retrofit.Builder()
            .baseUrl(EndPoint.baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(provideOkHttpClient())

        return builder.build()
    }

    fun getApiService(): ApiService = provideRetrofit().create(ApiService::class.java)
}