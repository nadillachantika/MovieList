package com.example.assignmentweek7_nadilla.adapter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.bumptech.glide.signature.ObjectKey
import com.example.assignmentweek7_nadilla.R
import com.example.assignmentweek7_nadilla.model.ResultsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieListAdapter :
    PagedListAdapter<ResultsItem, RecyclerView.ViewHolder>(ResultsItem().DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //https://pastebin.com/ZeiHC6GV
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)

        return MovieHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is MovieHolder) {
            holder.bindTo(getItem(position))
        }
    }

    class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindTo(item: ResultsItem?) {


            itemView.item_name.text = item?.name
            itemView.item_desk.text = item?.description
            itemView.item_item_count.text = item?.itemCount


//            Picasso.get().load("https://image.tmdb.org/t/p/w500${item?.poster_path}").into(itemView.item_image)
//
//
            Glide.with(itemView.context)
                .load("https://image.tmdb.org/t/p/w500${item?.poster_path}")
                .placeholder(R.drawable.progres_animation)
                .error(R.drawable.images)
                .into(itemView.item_image)


            //https://image.tmdb.org/t/p/w500$%7Bitem?.posterPath

        }

    }
}