package com.structure.tmdb.dashboard.moviemodels

sealed class MovieListInfoResult {
    data class Success(val data: MovieListItems) : MovieListInfoResult()
    data class Error(val errorMessage: String) : MovieListInfoResult()
    object Loading : MovieListInfoResult()
}