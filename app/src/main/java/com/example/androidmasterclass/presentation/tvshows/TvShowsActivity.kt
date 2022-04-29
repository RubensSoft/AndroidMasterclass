package com.example.androidmasterclass.presentation.tvshows

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidmasterclass.R
import com.example.androidmasterclass.databinding.ActivityTvShowsBinding
import com.example.androidmasterclass.presentation.di.Injector
import javax.inject.Inject

class TvShowsActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowViewModelFactory

    private lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var binding: ActivityTvShowsBinding
    private lateinit var adapter: TvShowsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_shows)

        (application as Injector).createTvShowSubComponent()
            .inject(this)

        tvShowViewModel = ViewModelProvider(this, factory)
            .get(TvShowViewModel::class.java)

        initRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateTvShows()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initRecyclerView() {
        binding.tvShowRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TvShowsAdapter()
        binding.tvShowRecyclerView.adapter = adapter

        displayPopularTvShows()
    }

    private fun displayPopularTvShows() {
        binding.tvShowProgressBar.visibility = View.VISIBLE

        val responseLiveData = tvShowViewModel.getTvShows()
        responseLiveData.observe(this) {
            it?.let {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            } ?: kotlin.run {
                binding.tvShowProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG)
            }
        }
    }

    private fun updateTvShows() {
        showProgressBar()

        val responseLiveData = tvShowViewModel.updateTvShows()
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
        binding.tvShowProgressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.tvShowProgressBar.visibility = View.GONE
    }
}