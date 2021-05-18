package com.example.assignmentweek7_nadilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.assignmentweek7_nadilla.adapter.MovieListAdapter
import com.example.assignmentweek7_nadilla.viewModel.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    private var viewModel :MovieViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        viewModel?.getMovie()

        viewModel?.movieData?.observe(this, Observer {

            val adapter = MovieListAdapter()
            adapter.submitList(it)
            listMovie.adapter = adapter
            progressBar.visibility= View.GONE

        })

        }


    }
