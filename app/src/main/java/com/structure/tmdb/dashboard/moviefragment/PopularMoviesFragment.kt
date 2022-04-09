package com.structure.tmdb.dashboard.dashboardfragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.structure.tmdb.R
import com.structure.tmdb.dashboard.dashboardviewmodel.PopularMoviesFragmentViewModel
import com.structure.tmdb.dashboard.moviemodels.MovieListInfoUIResult
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PopularMoviesFragment : Fragment() {
    private val viewModel: PopularMoviesFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       return inflater.inflate( R.layout.fragment_popular_movies , container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchMoviesList()
        initView()
        observeData()

    }
    private fun initView() {

    }
    private fun observeData() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED)
            {
                viewModel.getMovieResultFlow().collectLatest { result ->
                    when (result) {

                        is MovieListInfoUIResult.Success -> setUi {
                            Log.v("APICALL", "Data Before filtering ${result.data}")
                            println("Data Before filtering ${result.data}") }
                        is MovieListInfoUIResult.Error -> {

                        }
                        else -> {
                            Log.v("APICALL", "Loading in Fragment")
                            MovieListInfoUIResult.Loading
                        }
                    }
                }
            }
        }

    }

    private inline fun setUi(fn :()-> Unit) {
        fn()
    }
}