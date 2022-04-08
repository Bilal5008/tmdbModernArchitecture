package com.structure.tmdb.dashboard.dashboardmodels

sealed class MovieListInfoUIResult {
    data class  Success (val data : List <MovieListInfoUI>) : MovieListInfoUIResult()
    data class Error(val errorMessage: String) : MovieListInfoUIResult()
    object Loading : MovieListInfoUIResult()
}