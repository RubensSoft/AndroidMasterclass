package com.example.androidmasterclass.presentation.tvshows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidmasterclass.R
import com.example.androidmasterclass.data.model.movie.Movie
import com.example.androidmasterclass.data.model.tvshow.TvShow
import com.example.androidmasterclass.databinding.ListItemBinding

class TvShowsAdapter(): RecyclerView.Adapter<MyViewHolder>() {
    private val tvShowsList = ArrayList<TvShow>()

    fun setList(tvShows: List<TvShow>) {
        tvShowsList.clear()
        tvShowsList.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(tvShowsList[position])
    }

    override fun getItemCount(): Int {
        return tvShowsList.size
    }

}

class MyViewHolder(
    val binding: ListItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    private val url = "https://image.tmdb.org/t/p/w500"

    fun bind(tvShow: TvShow) {
        binding.titleTextView.text = tvShow.name
        binding.descriptionTextView.text = tvShow.overview

        val posterUrl = url + tvShow.posterPath
        Glide.with(binding.imageView.context)
            .load(posterUrl)
            .into(binding.imageView)
    }
}