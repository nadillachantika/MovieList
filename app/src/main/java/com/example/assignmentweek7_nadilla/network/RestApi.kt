package com.example.assignmentweek7_nadilla.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RestApi {

    companion object {
        fun restApi(): MovieService {

            //step 1 configurasi interceptor
            val inter = HttpLoggingInterceptor()
            inter.setLevel(HttpLoggingInterceptor.Level.BODY)

            //step 2 configurasi retrofit
            val okHttp = OkHttpClient().newBuilder().addInterceptor(inter).build()


            val retrofit = Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/movie/5/")
                .client(okHttp)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()


            //step 3 include configurasi retrofit ke interface

            return retrofit.create(MovieService::class.java)
        }
    }
}
