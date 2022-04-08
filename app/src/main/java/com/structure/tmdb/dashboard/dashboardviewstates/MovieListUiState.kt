package com.structure.tmdb.dashboard.dashboardviewstates

import com.structure.tmdb.dashboard.dashboardmodels.MovieListItems

data class MovieListUiState(
    val isLoading: Boolean = false,
    val movieListItems: List<MovieListItems> = listOf(),
    val errorMessage: String = "",
)