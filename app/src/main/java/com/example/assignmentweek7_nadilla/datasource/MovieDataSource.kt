package com.example.assignmentweek7_nadilla.datasource

import androidx.paging.PageKeyedDataSource
import com.example.assignmentweek7_nadilla.model.ResultsItem
import com.example.assignmentweek7_nadilla.network.MovieService
import com.example.assignmentweek7_nadilla.network.RestApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MovieDataSource :PageKeyedDataSource<Long,ResultsItem>(){

    var api : MovieService

    init {
        api = RestApi.restApi()
    }

    override fun loadInitial(
        params: LoadInitialParams<Long>,
        callback: LoadInitialCallback<Long, ResultsItem>

    ) {
        api.getMovie("b64d761def5c00e40e6a36e0032741bf",1,"Películas que ya he visto","1638",params.requestedLoadSize)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                t ->
                t.results?.let { callback.onResult(it,null,2L) }
            },{})


    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, ResultsItem>) {
        api.getMovie("b64d761def5c00e40e6a36e0032741bf",params.key,"Películas que ya he visto","1638",params.requestedLoadSize)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    t ->
                t.results?.let { callback.onResult(it,params.key+1) }
            },{})
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Long, ResultsItem>) {
        TODO("Not yet implemented")
    }

}