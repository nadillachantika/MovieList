package com.example.assignmentweek7_nadilla.viewModel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.assignmentweek7_nadilla.factory.MovieDataFactory
import com.example.assignmentweek7_nadilla.model.ResultsItem
import java.util.concurrent.Executor
import java.util.concurrent.Executors


class MovieViewModel : ViewModel(){

    var executor : Executor
    var movieData : LiveData<PagedList<ResultsItem>>
    var progress = MutableLiveData<Int>()

    init {
        executor = Executors.newFixedThreadPool(5)

        var  movieFactory = MovieDataFactory()

        var movieListConfig = PagedList.Config.Builder()
            .setPageSize(20)
            .setInitialLoadSizeHint(10)
            .setEnablePlaceholders(false)
            .build()

        movieData = LivePagedListBuilder(movieFactory,movieListConfig)
            .setFetchExecutor(executor)
            .build()

    }

    fun getMovie(): LiveData<PagedList<ResultsItem>>{
        return movieData
    }


    fun setProgressbar(v: View){

        progress.setValue(0); //View.VISIBLE

        progress.setValue(2); //View.GONE

    }
}