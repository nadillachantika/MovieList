package com.example.assignmentweek7_nadilla.network

import com.example.assignmentweek7_nadilla.model.ResponseMovie
import io.reactivex.rxjava3.core.Flowable
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {


    @GET("lists")
    fun getMovie(@Query("api_key") api :String,
                 @Query("page") page :Long,
                 @Query("description") description :String,
                 @Query("item_count") item_count : String,
        @Query("total_result") total_result : Int):Flowable<ResponseMovie>

}