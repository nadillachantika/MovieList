package com.example.assignmentweek7_nadilla.factory

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.assignmentweek7_nadilla.datasource.MovieDataSource
import com.example.assignmentweek7_nadilla.model.ResultsItem


class MovieDataFactory :DataSource.Factory<Long,ResultsItem>() {

    var mutableLivedata: MutableLiveData<MovieDataSource>
    var newsDataSource: MovieDataSource

    init {
        mutableLivedata = MutableLiveData()
        newsDataSource = MovieDataSource()
    }

    override fun create(): DataSource<Long, ResultsItem> {
        mutableLivedata.postValue(newsDataSource)
        return newsDataSource

    }

    fun getMutableLiveData(): MutableLiveData<MovieDataSource> {
        return mutableLivedata
    }
}