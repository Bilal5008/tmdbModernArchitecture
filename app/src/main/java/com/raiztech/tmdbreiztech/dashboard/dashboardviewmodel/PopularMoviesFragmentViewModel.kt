package com.raiztech.tmdbreiztech.dashboard.dashboardviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raiztech.tmdbreiztech.base.Filter
import com.raiztech.tmdbreiztech.dashboard.dashboardmodels.MovieListInfoUIResult
import com.raiztech.tmdbreiztech.dashboard.moviesusecase.FetchPopularMoviesUseCase
import com.raiztech.tmdbreiztech.dashboard.moviesusecase.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularMoviesFragmentViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val fetchPopularMoviesUseCase: FetchPopularMoviesUseCase
): ViewModel() {
    private var filter : String = Filter.POPULAR.filter

    fun getMovieResultFlow () : Flow<MovieListInfoUIResult> = getPopularMoviesUseCase(filter =filter)

    fun fetchMoviesList()
    {
        viewModelScope.launch {
            fetchPopularMoviesUseCase(filter =filter )
        }
    }
}