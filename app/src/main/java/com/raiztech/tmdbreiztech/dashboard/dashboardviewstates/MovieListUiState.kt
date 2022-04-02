package com.raiztech.tmdbreiztech.dashboard.dashboardviewstates

import com.raiztech.tmdbreiztech.dashboard.dashboardmodels.MovieListItems

data class MovieListUiState(
    val isLoading: Boolean = false,
    val movieListItems: List<MovieListItems> = listOf(),
    val errorMessage: String = "",
)