package com.example.androidmasterclass.presentation.movie

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidmasterclass.R
import com.example.androidmasterclass.databinding.ActivityMovieBinding
import com.example.androidmasterclass.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: MovieViewModelFactory

    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: ActivityMovieBinding
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)

        (application as Injector).createMovieSubComponent()
            .inject(this)

        movieViewModel = ViewModelProvider(this, factory)
            .get(MovieViewModel::class.java)

        initRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initRecyclerView() {
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.movieRecyclerView.adapter = adapter

        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        showProgressBar()

        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this) {
            it?.let {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                hideProgressBar()
            } ?: kotlin.run {
                hideProgressBar()
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG)
            }
        }
    }

    private fun updateMovies() {
        showProgressBar()

        val responseLiveData = movieViewModel.updateMovies()
        responseLiveData.observe(this) {
            it?.let {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                hideProgressBar()
            } ?: kotlin.run {
                hideProgressBar()
            }
        }
    }

    private fun showProgressBar() {
        binding.movieProgressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.movieProgressBar.visibility = View.GONE
    }
}