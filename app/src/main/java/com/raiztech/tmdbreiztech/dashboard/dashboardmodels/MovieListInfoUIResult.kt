package com.raiztech.tmdbreiztech.dashboard.dashboardmodels

sealed class MovieListInfoUIResult {
    data class  Success (val data : MovieListInfoUI) : MovieListInfoUIResult()
    data class Error(val errorMessage: String) : MovieListInfoUIResult()
    object Loading : MovieListInfoUIResult()
}